package com.coding.leetcode.t4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SolutionThree {

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); //3.5
    }

    // O(log(m+n))time  O(1)space
    public double findMedianSortedArrays(int[] A, int[] B) {
        return A.length < B.length ? get(A, B) : get(B, A);
    }

    public double get(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int min = 0, max = m;
        int halfLen = (m + n + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = halfLen - i;
            if (i < m && B[j - 1] > A[i]) {
                min = i + 1;
            } else if (i > 0 && A[i - 1] > B[j]) {
                max = i - 1;
            } else {
                int rightMin, leftMax;
                if (i == 0) {
                    leftMax = B[j - 1];
                } else if (j == 0) {
                    leftMax = A[i - 1];
                } else {
                    leftMax = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                if (i == m) {
                    rightMin = B[j];
                } else if (j == n) {
                    rightMin = A[i];
                } else {
                    rightMin = Math.min(A[i], B[j]);
                }

                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0;
    }
}
