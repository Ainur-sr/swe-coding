package com.coding.leetcode.lyft.sub.t1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] resArr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numsMap.containsKey(diff)) {
                resArr[0] = numsMap.get(diff);
                resArr[1] = i;
                return resArr;
            }
            numsMap.put(nums[i], i);
        }
        return resArr;
    }

}
