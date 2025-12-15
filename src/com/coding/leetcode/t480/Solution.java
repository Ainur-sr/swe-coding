package com.coding.leetcode.t480;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        double[] result = solution.medianSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    // minQ (Max-heap) для хранения меньшей половины элементов окна
    // Вершина содержит максимальный элемент из меньшей половины
    private PriorityQueue<Integer> minQ;

    //maxQ (Min-heap) для хранения большей половины элементов окна
    // Вершина содержит минимальный элемент из большей половины
    private PriorityQueue<Integer> maxQ;

    // Текущий размер minQ (с учётом помеченных на удаление элементов)
    private int minQSize;

    // Текущий размер maxQ (с учётом помеченных на удаление элементов)
    private int maxQSize;

    // Размер скользящего окна
    private int k;

    // HashMap для ленивого удаления: ключ - элемент, значение - количество раз для удаления
    // Элементы помечаются здесь и физически удаляются только когда оказываются на вершине кучи
    private Map<Integer, Integer> toRemoveMap;

    /**
     * Основной метод для вычисления медианы в каждом скользящем окне размера k
     *
     * @param nums массив чисел
     * @param k    размер скользящего окна
     * @return массив медиан для каждого окна
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        // Валидация входных данных
        if (k == 0 || nums == null || nums.length == 0 || nums.length < k) {
            return new double[0];
        }

        // Инициализация структур данных
        // minQ использует reverseOrder для создания max-heap
        this.minQ = new PriorityQueue<>(Comparator.reverseOrder());
        this.maxQ = new PriorityQueue<>();
        this.minQSize = 0;
        this.maxQSize = 0;
        this.k = k;
        this.toRemoveMap = new HashMap<>();

        // Результирующий массив: для n элементов и окна k будет (n - k + 1) окон
        double[] result = new double[nums.length - k + 1];

        // Инициализация первого окна: добавляем первые k элементов
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        // Вычисляем медиану для первого окна
        result[0] = getMedian();

        // Обработка остальных окон: сдвигаем окно на один элемент вправо
        for (int i = k; i < nums.length; i++) {
            addNum(nums[i]);           // Добавляем новый элемент справа
            removeNum(nums[i - k]);    // Удаляем элемент слева (вышедший из окна)
            result[i - k + 1] = getMedian();  // Вычисляем медиану для текущего окна
        }

        return result;
    }

    /**
     * Добавляет новый элемент в одну из куч с последующей балансировкой
     * <p>
     * minQ содержит меньшую половину, maxQ - большую половину
     * Все элементы в minQ <= всех элементов в maxQ
     *
     * @param num элемент для добавления
     */
    private void addNum(int num) {
        // Определяем, в какую кучу добавить элемент
        // Если minQ пуста или элемент <= максимума меньшей половины,
        // добавляем в minQ (меньшая половина)
        if (minQ.isEmpty() || num <= minQ.peek()) {
            minQ.offer(num);
            minQSize++;
        } else {
            // Иначе элемент принадлежит большей половине
            maxQ.offer(num);
            maxQSize++;
        }
        // Балансируем кучи после добавления
        balance();
    }

    /**
     * Помечает элемент для удаления (ленивое удаление) с последующей балансировкой
     * <p>
     * Элемент не удаляется физически сразу, а помечается в toRemoveMap.
     * Физическое удаление происходит в методе prune(), когда элемент оказывается на вершине.
     *
     * @param num элемент для удаления
     */
    private void removeNum(int num) {
        // Помечаем элемент для удаления в HashMap
        toRemoveMap.put(num, toRemoveMap.getOrDefault(num, 0) + 1);

        // Определяем, из какой кучи логически удаляем элемент
        // и уменьшаем соответствующий счётчик размера
        if (!minQ.isEmpty() && num <= minQ.peek()) {
            // Элемент принадлежит меньшей половине (minQ)
            minQSize--;
            // Если удаляемый элемент на вершине minQ, очищаем вершину сразу
            if (!minQ.isEmpty() && Objects.equals(minQ.peek(), num)) {
                prune(minQ);
            }
        } else {
            // Элемент принадлежит большей половине (maxQ)
            maxQSize--;
            // Если удаляемый элемент на вершине maxQ, очищаем вершину сразу
            if (!maxQ.isEmpty() && Objects.equals(maxQ.peek(), num)) {
                prune(maxQ);
            }
        }
        // Балансируем кучи после удаления
        balance();
    }

    /**
     * Балансирует размеры двух куч для корректного вычисления медианы
     * <p>
     * Инвариант после балансировки:
     * - Если k нечётное: maxSize = minSize + 1 (медиана в minQ)
     * - Если k чётное: maxSize = minSize (медиана - среднее вершин)
     */
    private void balance() {
        // Если minQ слишком большая (разница > 1), перемещаем элемент в maxQ
        if (minQSize > maxQSize + 1) {
            maxQ.offer(minQ.poll());
            minQSize--;
            maxQSize++;
            // Очищаем вершину minQ от помеченных элементов после перемещения
            prune(minQ);
        }
        // Если maxQ больше minQ, перемещаем элемент в minQ
        else if (minQSize < maxQSize) {
            minQ.offer(maxQ.poll());
            maxQSize--;
            minQSize++;
            // Очищаем вершину maxQ от помеченных элементов после перемещения
            prune(maxQ);
        }
    }

    /**
     * Удаляет из вершины кучи все элементы, помеченные для удаления в toRemoveMap
     * <p>
     * Это "ленивое удаление": элементы физически удаляются только когда оказываются
     * на вершине кучи, что позволяет избежать дорогостоящего поиска внутри кучи.
     *
     * @param heap куча для очистки (minQ или maxQ)
     */
    private void prune(PriorityQueue<Integer> heap) {
        // Продолжаем удалять элементы с вершины, пока они помечены в toRemoveMap
        while (!heap.isEmpty()) {
            Integer top = heap.peek();
            Integer count = toRemoveMap.get(top);

            // Если элемент не помечен для удаления, прекращаем очистку
            if (count == null || count == 0) {
                break;
            }

            // Удаляем элемент с вершины
            heap.poll();

            // Обновляем счётчик в toRemoveMap
            if (count == 1) {
                // Если это последнее вхождение, удаляем запись из HashMap
                toRemoveMap.remove(top);
            } else {
                // Иначе уменьшаем счётчик
                toRemoveMap.put(top, count - 1);
            }
        }
    }

    /**
     * Вычисляет медиану текущего окна на основе вершин двух куч
     *
     * @return медиана текущего окна
     */
    private double getMedian() {
        // Для нечётного k медиана - это вершина minQ (средний элемент)
        if (k % 2 == 1) {
            return (double) minQ.peek();
        }
        // Для чётного k медиана - среднее арифметическое вершин обеих куч
        else {
            // Приведение к double для корректного деления
            // Складываем вершины и делим на 2
            return ((double) minQ.peek() + (double) maxQ.peek()) / 2.0;
        }
    }
}