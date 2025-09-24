package com.coding.leetcode.t17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (digits == null || digits.isBlank()) {
            return Collections.emptyList();
        }

        backtrack(digits, 0, resList, sb);
        return resList;
    }

    private void backtrack(String digits, int index, List<String> resList, StringBuilder sb) {
        if (digits.length() == index) {
            resList.add(sb.toString());
            return;
        }

        int num = Character.getNumericValue(digits.charAt(index));
        if (num == 0 || num == 1) {
            return;
        }

        String letters = KEYS[num];
        for (char letter: letters.toCharArray()) {
            sb.append(letter);
            backtrack(digits, index + 1, resList, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
