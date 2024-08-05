package com.coding.leetcode.amazon.dynamicProg.t139_WordBreak;

import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        System.out.println(sol.wordBreak("leetcode", List.of("leet", "code"))); //true
        System.out.println(sol.wordBreak("applepenapple", List.of("apple", "pen"))); //true
        System.out.println(sol.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); //false
        System.out.println(sol.wordBreak("aaaaaaa", List.of("aaaa", "aaa"))); //true
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i > -1; i--) {

            for (String w : wordDict) {
                if (i + w.length() <= s.length()) {
                    String sub = s.substring(i, i + w.length());
                    if (sub.equals(w)) {
                        dp[i] = dp[i + w.length()];
                    }
                }
                if (dp[i]) break;
            }

        }

        return dp[0];
    }


}
