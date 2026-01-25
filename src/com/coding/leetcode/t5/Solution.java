package com.coding.leetcode.t5;

public class Solution {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        int[] resArray = new int[3]; // 0 -> maxSize / 1 -> startIndex / 2 -> endIndex

        for (int i = 0; i < s.length(); i++) {
            //odd length palindrome
            checkSubStr(resArray, s, i, i);

            //even length palindrome
            checkSubStr(resArray, s, i, i + 1);
        }

        return s.substring(resArray[1], resArray[2] + 1);
    }

    private void checkSubStr(int[] resArray, String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            int length = right - left + 1;
            if (length > resArray[0]) {
                resArray[1] = left;
                resArray[2] = right;
                resArray[0] = length;
            }
            left--;
            right++;
        }
    }


}
