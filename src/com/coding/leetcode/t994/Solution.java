package com.coding.leetcode.t994;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2, 1, 1},
                {1, 1, 1},
                {1, 0, 1}};

        int res = orangesRotting(arr);

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("--- --- --- --- --- --- --- --- --- --- --- ---");
        System.out.println(res);
    }

    static Queue<Node> queue = null;
    static int countOne = 0;

    public static int orangesRotting(int[][] grid) {
        int hours = 0;
        queue = new LinkedList<>();
        countOne = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    Node node = new Node(0, r, c);
                    queue.add(node);
                }
                if (grid[r][c] == 1) countOne++;
            }
        }

        while (!queue.isEmpty()) {
            Node checkNode = queue.poll();
            makeAppleBad(grid, checkNode.row, checkNode.col, checkNode.hour + 1);
            hours = checkNode.hour;
        }

        if(countOne > 0) return -1;
        else return hours;
    }

    private static void makeAppleBad(int[][] grid, int rowInd, int colInd, int nextHour) {
        //up
        if (rowInd > 0 && grid[rowInd - 1][colInd] == 1) {
            markCeil(grid, rowInd - 1, colInd, nextHour);
        }
        //down
        if (rowInd < grid.length - 1 && grid[rowInd + 1][colInd] == 1) {
            markCeil(grid, rowInd + 1, colInd, nextHour);
        }
        //left
        if (colInd > 0 && grid[rowInd][colInd - 1] == 1) {
            markCeil(grid, rowInd, colInd - 1, nextHour);
        }
        //right
        if (colInd < grid[rowInd].length - 1 && grid[rowInd][colInd + 1] == 1) {
            markCeil(grid, rowInd, colInd + 1, nextHour);
        }
    }

    private static void markCeil(int[][] grid, int rowInd, int colInd, int nextHour) {
        grid[rowInd][colInd] = 2;
        Node node = new Node(nextHour, rowInd, colInd);
        queue.add(node);
        countOne--;
    }

    static class Node {
        int hour;
        int row;
        int col;

        public Node(int hour, int row, int col) {
            this.hour = hour;
            this.row = row;
            this.col = col;
        }
    }
}
