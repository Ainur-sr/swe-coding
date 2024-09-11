package com.coding.leetcode.t1249;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minRemoveToMakeValid("))((")); // ""
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openBr = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBr++;
            } else if (ch == ')') {
                if (openBr == 0) continue;
                openBr--;
            }

            sb.append(ch);
        }

        StringBuilder res = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == '(' && openBr > 0) {
                openBr--;
                continue;
            }
            res.append(ch);
        }


        return res.reverse().toString();
    }
}
