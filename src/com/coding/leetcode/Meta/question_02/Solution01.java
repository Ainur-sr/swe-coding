package com.coding.leetcode.Meta.question_02;

public class Solution01 {

    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        String s = sol.countAndSay(4);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n is less then 1");
        }
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            String strNum = sb.toString();
            sb.setLength(0);

            int count = 1;
            char curChar = strNum.charAt(0);

            for (int k = 1; k < strNum.length(); k ++) {
                char nextChar = strNum.charAt(k);
                if (nextChar == curChar) {
                    count++;
                } else {
                    sb.append(count).append(curChar);
                    curChar = nextChar;
                    count = 1;
                }
            }
            sb.append(count).append(curChar);
        }

        return sb.toString();
    }
}
