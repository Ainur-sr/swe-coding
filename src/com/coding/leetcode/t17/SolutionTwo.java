package com.coding.leetcode.t17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTwo {

    Map<Character, List<Character>> letterMap = getLetterMap();

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, resList, sb);
        return resList;
    }

    private void dfs(int start, String digits, List<String> resList, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            resList.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            List<Character> characters = letterMap.get(digits.charAt(i));

            for (Character ch : characters) {
                sb.append(ch);
                dfs(i + 1, digits, resList, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private Map<Character, List<Character>> getLetterMap() {
        Map<Character, List<Character>> letterMap = new HashMap<>();
        letterMap.put('0', Collections.emptyList());
        letterMap.put('1', Collections.emptyList());
        letterMap.put('2', List.of('a', 'b', 'c'));
        letterMap.put('3', List.of('d', 'e', 'f'));
        letterMap.put('4', List.of('g', 'h', 'i'));
        letterMap.put('5', List.of('j', 'k', 'l'));
        letterMap.put('6', List.of('m', 'n', 'o'));
        letterMap.put('7', List.of('p', 'q', 'r', 's'));
        letterMap.put('8', List.of('t', 'u', 'v'));
        letterMap.put('9', List.of('w', 'x', 'y', 'z'));
        return letterMap;
    }

}
