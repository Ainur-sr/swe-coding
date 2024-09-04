package com.coding.leetcode.t2033;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

    }

    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int[] arrInt = new int[n * m];
        int i = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                arrInt[i] = grid[r][c];
                i++;
            }
        }
        Arrays.sort(arrInt);
        int res = 0;
        int target = arrInt[arrInt.length / 2];
        for (int num : arrInt) {
            int diff = Math.abs(target - num);
            if (diff == 0) continue;
            if ((diff % x) != 0) return -1;

            res = res + (diff / x);
        }

        return res;
    }

}
