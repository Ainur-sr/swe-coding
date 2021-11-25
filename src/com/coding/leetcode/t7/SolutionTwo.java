package com.coding.leetcode.t7;

public class SolutionTwo {

    public static void main(String[] args) {
        System.out.println(reverse(-123)); //-321
        System.out.println(reverse(123)); //321
        System.out.println(reverse(-2_147_483_412)); //-2143847412
        System.out.println(reverse(-2_147_483_648)); //0
    }

    public static int reverse(int x) {
        int d = x;
        int res = 0;

        while (d != 0) {
            int remainder = d % 10;
            d = d / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            res = res * 10 + remainder;
        }

        return res;
    }

}
