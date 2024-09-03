package com.coding.leetcode.t238;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix;
            prefix = nums[i] * prefix;
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = postfix * ans[i];
            postfix = nums[i] * postfix;
        }

        return ans;
    }



}
