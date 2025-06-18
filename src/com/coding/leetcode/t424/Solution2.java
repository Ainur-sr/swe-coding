package com.coding.leetcode.t424;

public class Solution2 {


    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int[] abcArr = new int[26];
        int res = 0;

        while (right < s.length()) {
            int iR = getIndex(s.charAt(right));
            abcArr[iR]++;
            maxFreq = Math.max(abcArr[iR], maxFreq);

            if ((right - left + 1) - maxFreq > k) {
                int iL = getIndex(s.charAt(left));
                abcArr[iL]--;
                left++;
            } else {
                res = Math.max(res, right - left + 1);
            }

            right++;
        }

        return res;
    }

    private int getIndex(char ch) {
        return ch - 'A';
    }
}
