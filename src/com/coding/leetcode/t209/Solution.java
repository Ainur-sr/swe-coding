package com.coding.leetcode.t209;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }

}
