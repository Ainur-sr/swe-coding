package com.coding.leetcode.t198;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {2, 7, 9, 3, 1};
        System.out.println(s.rob(nums1)); //12
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] checkArr = new int[nums.length];
        checkArr[0] = nums[0];
        checkArr[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int n1 = checkArr[i - 2] + nums[i];
            int n2 = checkArr[i - 1];

            checkArr[i] = Math.max(n1, n2);
        }

        return checkArr[checkArr.length - 1];
    }
}
