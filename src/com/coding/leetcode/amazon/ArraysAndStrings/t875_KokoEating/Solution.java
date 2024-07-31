package com.coding.leetcode.amazon.ArraysAndStrings.t875_KokoEating;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        int[] arr = new int[]{312_884_470};
//        int h = 312_884_469;
//        System.out.println(minEatingSpeed(arr, h)); // 2

        int[] arr = new int[]{805_306_368,805_306_368,805_306_368};
        int h = 1_000_000_000;
        System.out.println(minEatingSpeed(arr, h)); // 3
    }

    public static int minEatingSpeed(int[] piles, int h) {
        long maxBananas = Arrays.stream(piles).max().getAsInt();
        for (int pile : piles) {
            if (pile > maxBananas) {
                maxBananas = pile;
            }
        }

        long left = 1;
        long right = maxBananas;
        long res = right;

        while (left <= right) {
            long speed = left + (right - left) / 2;

            long hoursSpend = calcEatingSpeed(piles, speed);

            if (hoursSpend <= h) {
                res = speed;
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }

        return (int) res;
    }

    private static long calcEatingSpeed(int[] piles, long speed) {
        long hours = 0;
        for (int bananas : piles) {
            hours = (long) (hours + Math.ceil((double) bananas / speed));
        }
        return hours;
    }

}
