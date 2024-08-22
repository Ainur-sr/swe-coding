package com.coding.leetcode.amazon.ArraysAndStrings.t13_RomanToInteger;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol2 = new Solution2();
        String r1 = "MCMXCIV"; //1994
        String r2 = "LVIII"; //58
        String r3 = "DCXXI"; //621

        System.out.println(sol2.romanToInt(r1));
        System.out.println(sol2.romanToInt(r2));
        System.out.println(sol2.romanToInt(r3));
    }

    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {
        int num = 0;
        int j = 0;

        while (j < s.length()){
            if (j < s.length() - 1) {
                String subDouble = s.substring(j, j + 2);
                Integer x = values.get(subDouble);
                if (x != null) {
                    num = num + x;
                    j = j + 2;
                    continue;
                }
            }

            String subSingle = s.substring(j, j + 1);
            Integer x = values.get(subSingle);
            num = num + x;
            j = j + 1;
        }

        return num;
    }

}
