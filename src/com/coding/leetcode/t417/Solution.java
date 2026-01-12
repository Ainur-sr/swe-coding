package com.coding.leetcode.t417;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pacific, heights[0][c], heights);
            dfs(ROWS - 1, c, atlantic, heights[ROWS - 1][c], heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pacific, heights[r][0], heights);
            dfs(r, COLS - 1, atlantic, heights[r][COLS - 1], heights);
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    resList.add(List.of(r, c));
                }
            }
        }

        return resList;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeigh, int[][] heights) {
        if (r < 0 || r == ROWS || c < 0 || c == COLS) {
            return;
        }
        if (visited[r][c] == true) {
            return;
        }
        if (heights[r][c] < prevHeigh) {
            return;
        }
        visited[r][c] = true;

        int[][] coordinates = new int[][] {
                {r + 1, c},
                {r - 1, c},
                {r, c + 1},
                {r, c - 1},
        };

        for (int[] coordinate : coordinates) {
            dfs(coordinate[0], coordinate[1], visited, heights[r][c], heights);
        }
    }

}
