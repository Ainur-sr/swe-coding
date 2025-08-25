package com.coding.leetcode.t518;

public class Solution {


    public int change(int amount, int[] coins) {
        int[] amtMap = new int[amount + 1];
        amtMap[0] = 1;

        for (int coin : coins) {
            for (int amt = coin; amt <= amount; amt++) {
                amtMap[amt] += amtMap[amt - coin];
            }
        }

        return amtMap[amount];
    }
}
