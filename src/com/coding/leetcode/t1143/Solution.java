package com.coding.leetcode.t1143;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] matrix = new int[m + 1][n + 1];

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                int text1Index = r - 1;
                int text2Index = c - 1;
                if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
                    matrix[r][c] = matrix[r - 1][c - 1] + 1;
                } else {
                    int upVal = matrix[r - 1][c];
                    int leftVal = matrix[r][c - 1];
                    matrix[r][c] = Math.max(upVal, leftVal);
                }
            }
        }
        return matrix[m][n];

    }
}
