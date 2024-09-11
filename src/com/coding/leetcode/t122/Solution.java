package com.coding.leetcode.t122;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); //7

    }

    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int profit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int diff = prices[r] - prices[l];
                profit = profit + diff;
            }
            l = r;
            r++;
        }

        return profit;
    }

}
