package com.coding.leetcode.amazon.custom.t1_parking_lot;

public class ParkingLotUnionFind {

    /**
     * Проверяет, могут ли все машины припарковаться
     * Использует Union-Find с path compression для O(n * α(n)) ≈ O(n)
     *
     * @param n количество парковочных мест (0-indexed: 0 до n-1)
     * @param preferences массив предпочтений каждой машины
     * @return true если все могут припарковаться, иначе false
     */
    public boolean canPark(int n, int[] preferences) {
        // nextFree[i] указывает на следующее свободное место начиная с позиции i
        // Используется как parent array в Union-Find структуре
        int[] nextFree = new int[n + 1];

        // Инициализация: каждое место указывает на себя
        for (int i = 0; i <= n; i++) {
            nextFree[i] = i;
        }

        // Обрабатываем каждую машину по порядку прибытия
        for (int pref : preferences) {
            // Находим первое свободное место с path compression
            int spot = find(nextFree, pref);

            // Если вышли за границы парковки - машина не может припарковаться
            if (spot >= n) {
                return false;
            }

            // Паркуем машину: объединяем spot с spot+1
            // Теперь spot указывает на следующее свободное место
            nextFree[spot] = spot + 1;
        }

        return true;
    }

    /**
     * Find операция с path compression
     * Рекурсивно находит первое свободное место и сжимает путь
     *
     * @param nextFree массив указателей на следующие свободные места
     * @param pos начальная позиция поиска
     * @return номер первого свободного места
     */
    private int find(int[] nextFree, int pos) {
        // Если место указывает на себя - оно свободно
        if (nextFree[pos] == pos) {
            return pos;
        }

        // Path compression: обновляем указатель напрямую на корень
        // Это оптимизирует последующие поиски
        nextFree[pos] = find(nextFree, nextFree[pos]);
        return nextFree[pos];
    }

}
