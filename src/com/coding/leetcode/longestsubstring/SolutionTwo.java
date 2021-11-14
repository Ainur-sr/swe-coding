package com.coding.leetcode.longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class SolutionTwo {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf")); //3
        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("")); //0
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int startIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            char symb = chars[i];

            if (hashSet.isEmpty()){
                startIndex = i;
            }

            if (hashSet.contains(symb)) {
                hashSet.clear();
                i = startIndex;
            } else {
                hashSet.add(symb);
            }

            if (max < hashSet.size()) {
                max = hashSet.size();
            }
        }

        return max;
    }

}
