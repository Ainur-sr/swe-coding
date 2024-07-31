package com.coding.leetcode.amazon.ArraysAndStrings.t1_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];

            if (map.containsKey(n)){
                return new int[] {i, map.get(n)};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
