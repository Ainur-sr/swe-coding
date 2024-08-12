package com.coding.leetcode.amazon.ArraysAndStrings.t2340_MinimumAdjacentSwaps;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumSwaps(new int[]{3, 4, 5, 5, 3, 1});
    }

    public int minimumSwaps(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int count = 0;
        for (int i = maxIndex; i < nums.length - 1; i++) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
            if (minIndex == i + 1) {
                minIndex = i;
            }
            count++;
        }

        for (int i = minIndex; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
            count++;
        }

        return count;
    }

}
