package com.coding.leetcode.amazon.ArraysAndStrings.t13_RomanToInteger;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String r1 = "MCMXCIV"; //1994
        String r2 = "LVIII"; //58
        String r3 = "DCXXI"; //621

        System.out.println(sol.romanToInt(r1));
        System.out.println(sol.romanToInt(r2));
        System.out.println(sol.romanToInt(r3));
    }

    static final int[] values = new int[]{
            1, 4, 5, 9,
            10, 40, 50, 90,
            100, 400, 500, 900,
            1000};

    static final String[] romans = new String[]{
            "I", "IV", "V", "IX",
            "X", "XL", "L", "XC",
            "C", "CD", "D", "CM",
            "M"};

    public int romanToInt(String s) {
        int resNum = 0;
        StringBuilder sb = new StringBuilder();
        int startIdx = 0;

        for (int i = romans.length - 1; i >= 0; i--) {
            String roman = romans[i];

            for (int j = startIdx; j < s.length(); j++) {
                char c = s.charAt(j);
                sb.append(c);

                if (roman.length() < sb.length() || roman.charAt(0) != sb.charAt(0)) {
                    sb.setLength(0);
                    break;
                }
                if (roman.contentEquals(sb)) {
                    resNum = resNum + values[i];
                    sb.setLength(0);
                    startIdx = j + 1;
                }
            }

            sb.setLength(0);
        }

        return resNum;
    }

}
