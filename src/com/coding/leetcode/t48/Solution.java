package com.coding.leetcode.t48;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
/*        int[][] arr1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(arr1);*/

        int[][] arr2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(arr2);

        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        int s = matrix.length - 1;
        int l = matrix.length / 2;

        for (int i = 0; i < l; i++) {
            for (int k = i; k < (s - i); k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[s - k][i];
                matrix[s - k][i] = matrix[s - i][s - k];
                matrix[s - i][s - k] = matrix[k][s - i];
                matrix[k][s - i] = tmp;
            }
        }
    }

}
