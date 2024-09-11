package com.coding.leetcode.t344;

public class Solution {

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        char tmp;
        while (l < r) {
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }

}
