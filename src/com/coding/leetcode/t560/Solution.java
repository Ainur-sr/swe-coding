package com.coding.leetcode.t560;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0, 1);

        int sum = 0;
        int total = 0;

        for (int num : nums) {
            sum = sum + num; //Current prefix sum

            int neededPrefix = sum - k;
            int neededPrefixCount = prefixCountMap.getOrDefault(neededPrefix, 0);

            total = total + neededPrefixCount;

            // Record the current prefix sum
            int curPrefixCount = prefixCountMap.getOrDefault(sum, 0) + 1;
            prefixCountMap.put(sum, curPrefixCount);
        }
        return total;
    }
}
