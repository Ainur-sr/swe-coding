package com.coding.leetcode.amazon.ArraysAndStrings.t273_IntegerToEnglishWords;

public class Solution {

    private static final String[] ONE_TO_NINE = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private static final String[] TEN_TO_NINETEEN = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] TEN_TO_NINETY = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final int MILL = 1_000_000;

    private static final int BILL = 1_000_000_000;

    public static void main(String[] args) {

    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        makeNum(num, sb);
        return sb.toString().trim();
    }

    private void makeNum(int num, StringBuilder sb) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            sb.append(ONE_TO_NINE[num]).append(" ");
        } else if (num < 20) {
            sb.append(TEN_TO_NINETEEN[num - 10]).append(" ");
        } else if (num < 100) {
            sb.append(TEN_TO_NINETY[num / 10]).append(" ");
            makeNum(num % 10, sb);
        } else if (num < 1000) {
            sb.append(ONE_TO_NINE[num / 100]).append(" Hundred ");
            makeNum(num % 100, sb);
        } else if (num < MILL) {
            makeNum(num / 1000, sb);
            sb.append("Thousand ");
            makeNum(num % 1000, sb);
        } else if (num < BILL) {
            makeNum(num / MILL, sb);
            sb.append("Million ");
            makeNum(num % MILL, sb);
        } else {
            makeNum(num / BILL, sb);
            sb.append("Billion ");
            makeNum(num % BILL, sb);
        }
    }

    // time O(1)
    // space O(1)
}
