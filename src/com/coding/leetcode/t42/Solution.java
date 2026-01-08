package com.coding.leetcode.t42;

public class Solution {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftInd = 0;
        int rightInd = height.length - 1;
        int res = 0;

        int leftMax = height[leftInd];
        int rightMax = height[rightInd];

        while (leftInd < rightInd) {
            if (leftMax <= rightMax) {
                leftInd++;
                int diff = leftMax - height[leftInd];
                if (diff > 0) {
                    res += diff;
                }

                leftMax = Math.max(leftMax, height[leftInd]);
            } else {
                rightInd--;
                int diff = rightMax - height[rightInd];
                if (diff > 0) {
                    res += diff;
                }

                rightMax = Math.max(rightMax, height[rightInd]);
            }
        }

        return res;
    }

}
