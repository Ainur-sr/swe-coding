package com.coding.leetcode.t704;

public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid  - 1;
            }
        }
        return -1;
    }

}
