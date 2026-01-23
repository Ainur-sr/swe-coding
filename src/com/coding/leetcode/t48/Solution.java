package com.coding.leetcode.t48;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution2 = new Solution();

        int[][] arr2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution2.rotate(arr2);

        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while ( l < r )
        {
            for(int i = 0; i < r - l; i++)
            {
                int top = l;
                int bottom = r;
                //save the "top left"
                int topLeft = matrix[top][l + i];

                //move "bottom left" into "top left"
                matrix[top][l + i] = matrix[bottom - i][l];

                // move "bottom right" into "bottom left"
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move "top right" into "bottom right"
                matrix[bottom][r - i] = matrix[top + i][r];

                // move "top left" into "top right"
                matrix[top + i][r] = topLeft;
            }

            r -= 1;
            l += 1;
        }
    }

}
