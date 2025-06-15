package com.coding.leetcode.amazon.ArraysAndStrings.t76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = solution2.minWindow("ADOBECODEBANC", "AABC");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int left = 0;
        int windowMatchSize = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (tMap.containsKey(ch)) {
                windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
                if (windowMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                    windowMatchSize++;
                }
            }

            while (windowMatchSize == tMap.size()) {
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minLeft = left;
                }
                char chL = s.charAt(left);
                if (tMap.containsKey(chL)) {
                    windowMap.put(chL, windowMap.get(chL) - 1);
                    if (windowMap.get(chL) < tMap.get(chL)) {
                        windowMatchSize--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
