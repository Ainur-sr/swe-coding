package com.coding.leetcode.t91;

import java.util.Arrays;

public class Solution {

    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }

    private int dfs(String s, int start, int[] memo) {
        if (start >= s.length()) {
            return 1;  // Нашли один способ декодирования
        }
        if (s.charAt(start) == '0') {
            return 0;  // Невалидное декодирование
        }

        if (memo[start] != -1) {
            return memo[start];  // Используем кэшированный результат
        }

        int ways = 0;

        // Декодируем 1 цифру
        ways = ways + dfs(s, start + 1, memo);

        // Декодируем 2 цифры
        if (start + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(start, start + 2));
            if (twoDigit <= 26) {
                ways += dfs(s, start + 2, memo);
            }
        }

        memo[start] = ways;
        return ways;
    }

}
