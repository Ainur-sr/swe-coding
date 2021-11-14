package com.coding.leetcode.t4;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {

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
        for (int i : nums1) {
            integers.add(i);
        }
        for (int i : nums2) {
            integers.add(i);
        }
        integers.sort(Integer::compareTo);

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
