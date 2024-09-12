package com.coding.leetcode.t53;

public class Solution {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;

        for (int n : nums) {
            if (current < 0) {
                current = 0;
            }
            current = current + n;
            max = Math.max(current, max);
        }

        return max;
    }

}
