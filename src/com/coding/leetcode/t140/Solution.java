package com.coding.leetcode.t140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> strings = s.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
        System.out.println(strings);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> cache = new HashMap<>();

        return backtrack(0, s, wordSet, cache);
    }

    private List<String> backtrack(int start, String s, Set<String> wordSet, Map<Integer, List<String>> cache) {
        if (start >= s.length()) {
            return List.of("");
        }
        if (cache.containsKey(start)) {
            return cache.get(start);
        }
        List<String> resList = new ArrayList<>();

        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (!wordSet.contains(sub)) {
                continue;
            }

            List<String> backtrackList = backtrack(end + 1, s, wordSet, cache);

            for (String string : backtrackList) {
                String newStr = sub;
                if (!string.isBlank()) {
                    newStr = newStr + " " + string;
                }
                resList.add(newStr);
            }

        }

        cache.put(start, resList);
        return resList;
    }

}
