package com.coding.leetcode.t4;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        System.out.println(s.findMedianSortedArrays(nums1, nums2)); // 2
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int[] arrA = nums1;
        int[] arrB = nums2;

        int totalLen = arrA.length + arrB.length;
        int halfLen = totalLen / 2;

        int l = 0;
        int r = arrA.length - 1;

        while (true) {
            int midA = Math.floorDiv((r + l), 2);
            int midB = halfLen - midA - 2;

            int leftA, rightA, leftB, rightB;

            if (midA >= 0) leftA = arrA[midA];
            else leftA = Integer.MIN_VALUE;

            if ((midA + 1) < arrA.length) rightA = arrA[midA + 1];
            else rightA = Integer.MAX_VALUE;

            if (midB >= 0) leftB = arrB[midB];
            else leftB = Integer.MIN_VALUE;

            if ((midB + 1) < arrB.length) rightB = arrB[midB + 1];
            else rightB = Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if (totalLen % 2 == 1) {
                    return Math.min(rightA, rightB);
                } else {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
            } else if (leftA > rightB) {
                r = midA - 1;
            } else {
                l = midA + 1;
            }

        }

    }

}
