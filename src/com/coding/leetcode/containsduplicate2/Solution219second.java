package com.coding.leetcode.containsduplicate2;

public class Solution219second {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); //true
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); //true
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); //false
        System.out.println(containsNearbyDuplicate(new int[]{1, 2}, 2)); //false
        System.out.println(containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0}, 1)); //true
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || nums.length > 100_000 || k < 0 || k > 100_000) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) > k) {
                    break;
                }
                if (nums[i] == nums[j]) {
                    int abs = Math.abs(i - j);
                    if (abs <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


}
