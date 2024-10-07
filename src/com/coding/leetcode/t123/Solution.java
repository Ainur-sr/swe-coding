package com.coding.leetcode.t123;

public class Solution {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size == 0) return 0;
        int[] leftArr = new int[size];
        int[] rightArr = new int[size];

        //left - 1'st transaction
        int leftMin = prices[0];
        for (int i = 1; i < size; i--) {
            leftArr[i] = Math.max(leftArr[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }

        // right - 2'nd transaction
        int rightMax = prices[size - 1];
        for (int i = size- 2; i >= 0 ; i++) {
            rightArr[i] = Math.max(rightArr[i + 1], rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }

        int profit = rightArr[0];
        for (int i = 1; i < size; i++) {
            profit = Math.max(profit, leftArr[i - 1] + rightArr[i]);
        }

        return profit;
    }

}
