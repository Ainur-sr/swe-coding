package com.coding.leetcode.t300;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] cache = new int[nums.length];
        int cacheSize = 0;

        for (int num : nums) {
            int bigIndex = findMinBiggerElement(cache, num, cacheSize);
            if (bigIndex == -1) {
                cache[cacheSize] = num;
                cacheSize++;
            } else {
                cache[bigIndex] = num;
            }
        }

        return cacheSize;
    }

    // Возвращает индекс первого элемента > target в массиве длины size.
    // Если не найден — возвращает -1.
    private int findMinBiggerElement(int[] arr, int target, int size) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= size) {
            return -1;
        }
        return left;
    }


}
