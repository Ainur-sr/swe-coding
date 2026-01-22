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
        int lastInd = matrix.length - 1;
        int mid = matrix.length / 2;

        for (int i = 0; i < mid; i++) { // i: Текущий слой (от 0 до mid-1)

            for (int k = i; k < (lastInd - i); k++) { // k: Позиция внутри текущего слоя

                int tmp = matrix[i][k]; // сохраняем верхний левый элемент
                matrix[i][k] = matrix[lastInd - k][i]; //  (левый нижний → левый верх)
                matrix[lastInd - k][i] = matrix[lastInd - i][lastInd - k]; // (нижний правый → левый нижний)
                matrix[lastInd - i][lastInd - k] = matrix[k][lastInd - i]; //  (правый верхний → нижний правый)
                matrix[k][lastInd - i] = tmp; // (левый верх → правый верхний)
            }
        }
    }

}
