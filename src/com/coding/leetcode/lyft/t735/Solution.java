package com.coding.leetcode.lyft.t735;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 10, -5};
        int[] nums1Res = asteroidCollision(nums1);
        System.out.println(Arrays.toString(nums1Res));

        int[] nums2 = new int[]{3, -69, -65, 67, -76, 34, 10, 96, 55, 77, 85, 56, 99, -1, 6, -37,
                                -7, -70, 75, -60, 4, -73, 35, -32, 3, -7, 72, 83, -82, 70, 68, 63,
                                33, -68, -100, 61, -96, 27, 89, 81, -11, -63, 69, 49, -34, 23, 87,
                                23, 26, -67, 67, -100, -84, -89, -76, -42, -86, -96, 86, 7, 25, 9,
                                -17, 7, -15, -35, -65, -82, -32, 90, -27, 39, 30, -42, -3, -71, -46,
                                24, 20, -84, 8, 51, -84, 24, 53, 66, 87, -64, 27, -5, -68, 86, -49,
                                -53, 68, 21, -88, 58, 21, -18};
        int[] nums2Res = asteroidCollision(nums2);
        //[-69,-65,-76,-100,-96,-100,-84,-89,-76,-42,-86,-96,86,90,58,21]
        System.out.println("\n" + Arrays.toString(nums2Res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        while (true) {
            boolean foundProblem = false;
            repLabel:
            for (int i = 0; i < asteroids.length - 1; i++) {
                if (asteroids[i] == 0) continue;

                int nextIdx = i + 1;
                while (asteroids[nextIdx] == 0) {
                    nextIdx++;
                    if (nextIdx == asteroids.length)
                        continue repLabel;
                }

                if (asteroids[i] > 0 && asteroids[nextIdx] < 0) {
                    if (Math.abs(asteroids[i]) > Math.abs(asteroids[nextIdx])) {
                        asteroids[nextIdx] = 0;
                    } else if (Math.abs(asteroids[i]) < Math.abs(asteroids[nextIdx])) {
                        asteroids[i] = 0;
                    } else {
                        asteroids[nextIdx] = 0;
                        asteroids[i] = 0;
                    }

                    foundProblem = true;
                }
            }

            if (!foundProblem) {
                break;
            }
        }

        return filterArr(asteroids);
    }

    private static int[] filterArr(int[] arr) {
        return Arrays.stream(arr).filter(item -> item != 0).toArray();
    }
}
