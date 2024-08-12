package com.coding.leetcode.amazon.sortingAndSearching.t167_TwoSum2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] ints = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }

            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[0];
    }

}
