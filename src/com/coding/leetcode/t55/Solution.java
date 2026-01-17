package com.coding.leetcode.t55;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int goalIndex = nums.length - 1;

        for (int i = nums.length - 1; i > -1; i--) {
            int shiftIndex = nums[i] + i;
            if (shiftIndex >= goalIndex) {
                goalIndex = i;
            }
        }

        if (goalIndex == 0) {
            return true;
        }
        return false;
    }
}
