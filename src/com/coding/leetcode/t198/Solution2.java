package com.coding.leetcode.t198;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol2 = new Solution2();
        int rob = sol2.rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }


    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;
            int curr = Math.max(skip, take);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
