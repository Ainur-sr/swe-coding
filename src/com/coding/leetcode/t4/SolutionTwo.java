package com.coding.leetcode.t4;

import java.util.*;

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
        List<Integer> integers = new ArrayList<>();

        int n1 = 0;
        int n2 = 0;
        while (n1 < nums1.length || n2 < nums2.length) {
            if (n1 < nums1.length && n2 < nums2.length) {
                if (nums1[n1] == nums2[n2]) {
                    integers.add(nums1[n1]);
                    integers.add(nums2[n2]);
                    n1++;
                    n2++;
                } else if (nums1[n1] > nums2[n2]) {
                    integers.add(nums2[n2]);
                    n2++;
                } else if (nums1[n1] < nums2[n2]) {
                    integers.add(nums1[n1]);
                    n1++;
                }

            } else if (n1 < nums1.length) {
                for (int k = n1; k < nums1.length; k++) {
                    integers.add(nums1[k]);
                }
                break;
            } else if (n2 < nums2.length) {
                for (int k = n2; k < nums2.length; k++) {
                    integers.add(nums2[k]);
                }
                break;
            } else {
                break;
            }
        }

        int index = 0;
        int mid = integers.size() / 2;
        int prev = 0;
        for (Integer integer : integers) {
            if (index == mid) {
                if (integers.size() % 2 == 1) {
                    result = integer;
                } else {
                    result = (integer + prev) / 2.0;
                }
                break;
            }
            prev = integer;
            index++;
        }

        return result;
    }

}
