package com.coding.leetcode.amazon.ArraysAndStrings.t11_ContainerWithMostWater;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(s.maxArea(height)); //49
    }


    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int len = right - left;
            int h = 0;
            if (height[left] <= height[right]) {
                h = height[left];
                left++;
            } else {
                h = height[right];
                right--;
            }
            max = Math.max(max, len * h);
        }

        return max;
    }

}
