package com.coding.leetcode.t96;

public class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if (n >= 1) {
            dp[1] = 1;
        }

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;

            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                total = total + dp[left] * dp[right];
            }
            dp[nodes] = total;
        }

        return dp[n];
    }

}
