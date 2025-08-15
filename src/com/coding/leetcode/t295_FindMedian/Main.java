package com.coding.leetcode.t295_FindMedian;

public class Main {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        addNums(medianFinder, new int[]{6, 10, 2, 6, 5});

        System.out.println(medianFinder.findMedian());
    }

    private static void addNums(MedianFinder medianFinder, int[] nums) {
        for (int num : nums) {
            medianFinder.addNum(num);
        }
    }

}
