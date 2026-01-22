package com.coding.leetcode.t16;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); //2

    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums != null && nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int clSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int n1 = nums[i];
                int n2 = nums[left];
                int n3 = nums[right];
                int sum = n1 + n2 + n3;

                if (Math.abs(target - sum) < Math.abs(target - clSum)) {
                    clSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return clSum;
    }

}
