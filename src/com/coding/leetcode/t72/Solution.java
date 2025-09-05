package com.coding.leetcode.t72;

public class Solution {

    /**
     +----------+--------+
     | replace  | insert |
     +----------+--------+
     | delete   | *      |
     +----------+--------+
     */

    public int minDistance(String word1, String word2) {
        final int w1Len = word1.length();
        final int w2Len = word2.length();

        int[][] matrix = new int[w2Len + 1][w1Len + 1];

        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = i;
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (word1.charAt(c - 1) == word2.charAt(r - 1)){
                    matrix[r][c] = matrix[r - 1][c - 1];
                } else{
                    int insert = matrix[r - 1][c];
                    int delete = matrix[r][c - 1];
                    int replace = matrix[r - 1][c - 1];
                    matrix[r][c] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

}
