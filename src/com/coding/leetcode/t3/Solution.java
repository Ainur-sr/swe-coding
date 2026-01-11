package com.coding.leetcode.t3;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("pwwkew")); //3

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            while (set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            max = Math.max(max, r - l  + 1);
        }

        return max;
    }

}
