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
        int start = 0;
        for (int cur = 0; cur < s.length(); ++cur) {
            Character ch = s.charAt(cur);

            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }

            map.put(ch, cur);
            max = Math.max(max, cur - start + 1);
        }

        return max;
    }

}
