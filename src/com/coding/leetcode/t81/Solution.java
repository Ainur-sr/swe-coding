package com.coding.leetcode.t81;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.search(new int[]{1, 0, 1, 1, 1}, 0));
//        System.out.println(s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(s.search(new int[]{3, 1}, 0));
    }

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = nums[mid];
            if (nums[mid] == target) {
                return true;
            }

            if (nums[l] < nums[mid]) { //left part
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[r]) { //right part
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if  (nums[l] == nums[mid]) {
                    l++;
                } else {
                    r--;
                }
            }

        }

        return false;
    }

}
