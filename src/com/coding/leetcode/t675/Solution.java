package com.coding.leetcode.t675;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public int cutOffTree(List<List<Integer>> forest) {
        int rows = forest.size();
        int cols = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();

        // 1. Собираем все деревья с высотой > 1
        // Каждое дерево представлено как [высота, строка, столбец]
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (forest.get(row).get(col) > 1) {
                    int height = forest.get(row).get(col);
                    trees.add(new int[]{height, row, col});
                }
            }
        }

        // 2. Сортируем деревья по возрастанию высоты
        // Необходимо срубать деревья от самого низкого к самому высокому
        trees.sort(Comparator.comparingInt(tree -> tree[0]));

        int totalSteps = 0;
        int startRow = 0;
        int startCol = 0;

        // 3. Идем к каждому дереву по порядку и срубаем его
        for (int[] tree : trees) {
            int targetRow = tree[1];
            int targetCol = tree[2];

            // Находим кратчайший путь от текущей позиции до следующего дерева
            int steps = bfs(forest, startRow, startCol, targetRow, targetCol);

            // Если путь не найден, возвращаем -1
            if (steps == -1) {
                return -1;
            }

            totalSteps += steps;
            // Обновляем текущую позицию
            startRow = targetRow;
            startCol = targetCol;
        }

        return totalSteps;
    }

    /**
     * BFS для поиска кратчайшего пути между двумя точками
     * @param forest - карта леса
     * @param startRow - начальная строка
     * @param startCol - начальный столбец
     * @param targetRow - целевая строка
     * @param targetCol - целевой столбец
     * @return количество шагов до цели или -1 если путь не существует
     */
    private int bfs(List<List<Integer>> forest,
                    int startRow, int startCol,
                    int targetRow, int targetCol) {

        // Если уже находимся в целевой точке
        if (startRow == targetRow && startCol == targetCol) {
            return 0;
        }

        int rows = forest.size();
        int cols = forest.get(0).size();

        // Очередь для BFS: [строка, столбец, количество шагов]
        Queue<int[]> queue = new LinkedList<>();
        // Массив для отслеживания посещенных клеток
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        // Направления движения: вниз, вверх, вправо, влево
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentRow = current[0];
            int currentCol = current[1];
            int steps = current[2];

            // Проверяем все 4 направления
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Проверка выхода за границы карты
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Проверка препятствий (0) и уже посещенных клеток
                if (visited[newRow][newCol] || forest.get(newRow).get(newCol) == 0) {
                    continue;
                }

                // Достигли целевой точки
                if (newRow == targetRow && newCol == targetCol) {
                    return steps + 1;
                }

                // Добавляем новую клетку в очередь
                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol, steps + 1});
            }
        }

        // Путь не найден
        return -1;
    }



}
