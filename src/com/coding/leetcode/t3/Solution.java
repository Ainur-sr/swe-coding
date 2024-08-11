package com.coding.leetcode.t3;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring1("dvdf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    //O(N)time O(N)space
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;

        for (int i = 0, j = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);

            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }

            map.put(ch, i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }

}
