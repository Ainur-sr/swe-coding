package com.coding.leetcode.t5;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab OR aba
        System.out.println(longestPalindrome("cbbd")); // bb
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) return "";
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandPalindrome(s, i, i);
            int len2 = expandPalindrome(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if ((end - start + 1) < maxLen) {
                start = i - ((maxLen - 1) / 2);
                end = i + (maxLen / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandPalindrome(String str, int left, int right) {
        if (str == null || right < left) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}
