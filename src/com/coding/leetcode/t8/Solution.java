package com.coding.leetcode.t8;

public class Solution {

    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        // 1. Trim
        String str = s.trim();
        if (str.isEmpty()) {
            return 0;
        }

        // 2. Check for sign '+' or '-'
        int i = 0;
        int sign = 1;
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            i++;
            sign = -1;
        }

        // 3. Parse
        long result = 0;
        for (int j = i; j < str.length(); j++) {
            char c = str.charAt(j);
            if (!Character.isDigit(c)) {
                break;
            }
            int n = Character.getNumericValue(c);
            result = result * 10 + n;

            // 4. Check for overflow/underflow
            if (sign == -1 && (sign * result) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return (int) (result * sign);
    }
}
