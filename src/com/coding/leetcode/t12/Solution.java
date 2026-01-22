package com.coding.leetcode.t12;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3749)); //"MMMDCCXLIX"
    }

    static final int[] values = new int[]{1, 4, 5, 9,
                                        10, 40, 50, 90,
                                        100, 400, 500, 900,
                                        1000};
    
    static final String[] romans = new String[]{"I", "IV", "V", "IX",
                                                "X", "XL", "L", "XC",
                                                "C", "CD", "D", "CM",
                                                "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = values.length - 1; i >= 0 && num > 0; i--) {
            while (num >= values[i]) {
                num = num - values[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();
    }
}
