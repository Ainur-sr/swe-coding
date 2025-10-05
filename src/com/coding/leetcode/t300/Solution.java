package com.coding.leetcode.t300;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> cache = new ArrayList<>();

        for (int num : nums) {
            int bigIndex = findMinBiggerElement(cache, num, cacheSize);
            if (bigIndex == -1) {
                cache.add(num)
            } else {
                cache.set(bigIndex, num);
            }
        }

        return cache.size();
    }

    // Возвращает индекс первого элемента > target
    // Если не найден — возвращает -1.
    private int findMinBiggerElement(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
