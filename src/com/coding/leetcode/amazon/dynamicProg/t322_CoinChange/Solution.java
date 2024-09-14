package com.coding.leetcode.amazon.dynamicProg.t322_CoinChange;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11)); //3
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int a = 1; a < amount + 1; a++) {

            for (int coin : coins) {
                if (a - coin >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
                }
            }
        }

        if (dp[amount] == amount + 1) return -1;

        return dp[amount];
    }


}
