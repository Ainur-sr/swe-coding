package com.coding.leetcode.t268;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            res = res - nums[i];
        }

        return res;
    }

}
