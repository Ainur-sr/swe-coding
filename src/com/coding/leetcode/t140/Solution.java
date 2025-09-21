package com.coding.leetcode.t140;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
        System.out.println(strings);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        Map<Integer, List<String>> memo = new HashMap<>();
        memo.put(s.length(), List.of(""));

        int maxWordLen = -1;
        for (String string : wordDict) {
            maxWordLen = Math.max(maxWordLen, string.length());
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = dfs(s, 0, wordSet, memo, maxWordLen, sb);


        return res;
    }

    private List<String> dfs(String s, int start, Set<String> wordSet,
                             Map<Integer, List<String>> memo, int maxWordLen, StringBuilder sb) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> resList = new ArrayList<>();

        int finish = Math.min(s.length(), maxWordLen + start);

        for (int end = start + 1; end <= finish; end++) {
            String sub = s.substring(start, end);
            if (wordSet.contains(sub)) {

                List<String> dfsList = dfs(s, end, wordSet, memo, maxWordLen, sb);
                for (String str : dfsList) {
                    sb.append(sub);
                    if (!str.isBlank()){
                        sb.append(" ");
                        sb.append(str);
                    }

                    resList.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        memo.put(start, resList);
        return resList;
    }


}
