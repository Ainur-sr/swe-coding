package com.coding.leetcode.t139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTwo {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (wordSet.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

}
