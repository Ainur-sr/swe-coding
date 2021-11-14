package com.coding.leetcode.longestsubstring;

public class SolutionOne {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf")); //3
        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("")); //0
    }

    public static int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            String symb = s.substring(i, i + 1);

            if (sb.length() == 0){
                startIndex = i;
            }

            if (sb.toString().contains(symb)) {
                sb.setLength(0);
                i = startIndex;
            } else {
                sb.append(symb);
            }

            if (max < sb.length()) {
                max = sb.length();
            }
        }

        return max;
    }

}
