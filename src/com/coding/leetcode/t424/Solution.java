package com.coding.leetcode.t424;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int a = new Solution().characterReplacement("AABABBA", 1);
        System.out.println(a);
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        int res = 0;
        int left = 0;
        int maxF = 0;

        for (int right = 0; right < s.length(); right++) {
            char chR = s.charAt(right);
            countMap.merge(chR, 1, Integer::sum);
            maxF = Math.max(maxF, countMap.get(chR));

            while (left <= right) {
                int size = right - left + 1;
                if (size - maxF <= k) {
                    res = Math.max(res, right - left + 1);
                    break;
                } else {
                    char chL = s.charAt(left);
                    countMap.merge(chL, -1, Integer::sum);
                    left++;
                }
            }
        }

        return res;
    }

}
