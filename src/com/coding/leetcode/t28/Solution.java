package com.coding.leetcode.t28;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.strStr2("sadbutsad", "sad")); // -> 0
        System.out.println(s.strStr2("buttozsad", "toz")); // -> 3
//        System.out.println(s.strStr2("aaa", "aaaa")); // -> -1
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int st = 0; st <= n - m; st++) {
            boolean isFound = true;
            for (int j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(st + j)) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) return st;
        }

        return -1;
    }

}
