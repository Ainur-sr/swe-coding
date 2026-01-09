package com.coding.leetcode.t994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol2 = new Solution2();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int i = sol2.orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int[] countFresh = new int[1];
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
                if (grid[r][c] == 1) {
                    countFresh[0]++;
                }
            }
        }

        while (!queue.isEmpty() && countFresh[0] > 0) {
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                int[] coordinates = queue.poll();
                markOrange(grid, countFresh, queue, coordinates[0], coordinates[1]);
            }
            time++;
        }

        return countFresh[0] > 0 ? -1 : time;
    }

    private void markOrange(int[][] grid, int[] countFresh, Queue<int[]> queue, int r, int c) {
        //up
        if (r > 0 && grid[r - 1][c] == 1) {
            markCeil(grid, r - 1, c, queue, countFresh);
        }

        //down
        if (r + 1 < grid.length && grid[r + 1][c] == 1) {
            markCeil(grid, r + 1, c, queue, countFresh);
        }

        //left
        if (c > 0 && grid[r][c - 1] == 1) {
            markCeil(grid, r, c - 1, queue, countFresh);
        }

        //right
        if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
            markCeil(grid, r, c + 1, queue, countFresh);
        }
    }

    private static void markCeil(int[][] grid, int r, int c, Queue<int[]> queue, int[] countFresh) {
        grid[r][c] = 2;
        queue.add(new int[] {r, c});
        countFresh[0]--;
    }

}
