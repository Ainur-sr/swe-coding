package com.coding.leetcode.amazon.sortingAndSearching.t4_MedianTwoSortedArrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        System.out.println(s.findMedianSortedArrays(nums1, nums2)); // 2
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        if (nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }

        int totalSize = A.length + B.length;
        int half = totalSize / 2;

        int left = 0;
        int right = A.length - 1;

        while (true) {
            int i = Math.floorDiv(left + right, 2); // A array
            int j = half - i - 2; // B array

            int Aleft, Aright, Bleft, Bright;

            if (i >= 0) Aleft = A[i];
            else Aleft = Integer.MIN_VALUE;

            if ((i + 1) < A.length) Aright = A[i + 1];
            else Aright = Integer.MAX_VALUE;

            if (j >= 0) Bleft = B[j];
            else Bleft = Integer.MIN_VALUE;

            if ((j + 1) < B.length) Bright = B[j + 1];
            else Bright = Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                //odd
                if (totalSize % 2 == 1)
                    return Math.min(Aright, Bright);
                //even
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

    }

}
