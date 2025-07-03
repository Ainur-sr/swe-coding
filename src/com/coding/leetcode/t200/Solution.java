package com.coding.leetcode.t200;

public class Solution {

    public static void main(String[] args) {
        char[] n1 = new char[]{'1', '1', '1', '1', '0'};
        char[] n2 = new char[]{'1', '1', '0', '1', '0'};
        char[] n3 = new char[]{'1', '1', '0', '0', '0'};
        char[] n4 = new char[]{'0', '0', '0', '0', '0'};
        char[][] n = new char[][]{n1, n2, n3, n4}; // res = 1
        System.out.println(numIslands(n));

        char[] m1 = new char[]{'1', '1', '0', '0', '0'};
        char[] m2 = new char[]{'1', '1', '0', '0', '0'};
        char[] m3 = new char[]{'0', '0', '1', '0', '0'};
        char[] m4 = new char[]{'0', '0', '0', '1', '1'};
        char[][] m = new char[][]{m1, m2, m3, m4}; // res = 3
        System.out.println(numIslands(m));

    }


    public static int numIslands(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }

            }
        }

        return numIslands;
    }

    private static void dfs(char[][] grid, int row, int col) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        grid[row][col] = '5';

        //up
        if (row > 0 && grid[row - 1][col] == '1')  {
            dfs(grid, row - 1, col);
        }
        //left
        if (col > 0 && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1);
        }
        //down
        if (row < rowSize - 1 && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col);
        }
        //right
        if (col < colSize - 1 && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1);
        }
    }


}
