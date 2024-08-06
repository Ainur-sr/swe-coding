package com.coding.leetcode.amazon.dynamicProg.t121_BestTime;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices1 = {2, 4, 1};
//        System.out.println(solution.maxProfit(prices1)); // 2

        int[] prices2 = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices2)); // 5
    }

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }

}
