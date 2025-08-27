package com.coding.leetcode.t213;

public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int v1 = robHouses(nums, 0, nums.length - 2);
        int v2 = robHouses(nums, 1, nums.length - 1);

        return Math.max(v1, v2);
    }

    private int robHouses(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int take = prev2 + nums[i];
            int skip = prev1;
            int cur = Math.max(take, skip);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

}
