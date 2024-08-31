package com.coding.leetcode.amazon.ArraysAndStrings.t76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(solution.minWindow("a", "a")); // a
    }


    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int resStart = 0;
        int resEnd = -1;
        int resSize = Integer.MAX_VALUE;

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            windowMap.put(c, 0);
        }

        int winCount = 0;
        int targetCount = targetMap.size();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (targetMap.containsKey(rightChar)) {
                Integer chWinCount = windowMap.get(rightChar);
                chWinCount++;
                windowMap.put(rightChar, chWinCount);

                if (chWinCount.equals(targetMap.get(rightChar))) {
                    winCount++;
                }
            }

            while (winCount == targetCount) {
                //update result
                if (right - left + 1 < resSize) {
                    resStart = left;
                    resEnd = right;
                    resSize = right - left + 1;
                }

                //pop from the left of our window
                char leftChar = s.charAt(left);
                if (windowMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                    if (windowMap.get(leftChar) < targetMap.get(leftChar)) {
                        winCount--;
                    }
                }
                left++;
            }
        }

        return s.substring(resStart, resEnd + 1);
    }


}
