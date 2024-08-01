package com.coding.leetcode.amazon.dynamicProg.t70_ClimbingStairs;

public class Solution {


    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if (n < 3) return n;

        int f1 = 1;
        int f2 = 2;
        for (int i = 0; i < n - 1; i++) {
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return f1;
    }

    // 5  => max i = 5-1 = 4 -> 3
    //i=0 tmp=0+1=1 / f1 = 1 / f2 = 1
    //i=1 tmp=1+1=2 / f1 = 1 / f2 = 2
    //i=2 tmp=1+2=3 / f1 = 2 / f2 = 3
    //i=3 tmp=2+3=5 / f1 = 3 / f2 = 5
    //i=4 tmp=3+5=5 / f1 = 5 / f2 = 8
}
