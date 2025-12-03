package com.coding.leetcode.t518;

public class Solution {


    public int change(int amount, int[] coins) {
        int[] resArr = new int[amount + 1];
        resArr[0] = 1;

        for (int coin : coins) {
            for (int a = 1; a <= amount; a++) {
                int not_use_coin = resArr[a];
                int use_coin = 0;
                if (a - coin >= 0) {
                    use_coin = resArr[a - coin];
                }
                resArr[a] = not_use_coin + use_coin;
            }
        }

        return resArr[amount];
    }
}
