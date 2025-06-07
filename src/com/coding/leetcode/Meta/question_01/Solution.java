package com.coding.leetcode.Meta.question_01;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int currentNumber = 1;
        int maxNumber = n * n;

        while (currentNumber <= maxNumber) {
            //fill top row
            for (int c = left; c <= right; c++) {
                matrix[top][c] = ++currentNumber;
            }
            top++;

            //fill right col
            for (int r = top; r <= bottom; r++) {
                matrix[r][right] = ++currentNumber;
            }
            right--;

            //fill bottom row (rev)
            for (int c = right; c >= left; c--) {
                matrix[bottom][c] = ++currentNumber;
            }
            bottom--;

            //fill left col (rev)
            for (int r = bottom; r >= top; r--) {
                matrix[r][left] = ++currentNumber;
            }
            left++;

        }

        return matrix;
    }
}
