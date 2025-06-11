package com.coding.leetcode.t3;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 sol3 = new Solution3();
        int n = sol3.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            Integer cInd = map.get(c);
            if (cInd != null && cInd >= left) {
                left = cInd + 1;
                map.put(c, right);
            } else {
                map.put(c, right);
                int count = right - left + 1;
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
