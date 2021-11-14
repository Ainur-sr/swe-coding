package com.coding.leetcode.t4;

public class SolutionTwo {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2.0
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1})); // 1.0
        System.out.println(findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2})); // 1.0
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2})); // 2.0
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0})); // 0.0
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int[] integers = new int[nums1.length + nums2.length];

        int n1 = 0;
        int n2 = 0;
        int x = 0;
        while (n1 < nums1.length && n2 < nums2.length) {
                if (nums1[n1] == nums2[n2]) {
                    integers[x++] = nums1[n1++];
                    integers[x++] = nums2[n2++];
                } else if (nums1[n1] > nums2[n2]) {
                    integers[x++] = nums2[n2++];
                } else if (nums1[n1] < nums2[n2]) {
                    integers[x++] = nums1[n1++];
                }
        }

        while (n1 < nums1.length){
            integers[x++] = nums1[n1++];
        }
        while (n2 < nums2.length){
            integers[x++] = nums2[n2++];
        }

        int mid = integers.length / 2;
        if (integers.length % 2 == 1) {
            result = integers[mid];
        } else {
            result = (integers[mid] + integers[mid-1]) / 2.0;
        }

        return result;
    }

}
