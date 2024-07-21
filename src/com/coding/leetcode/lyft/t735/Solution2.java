package com.coding.leetcode.lyft.t735;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        int[] nums2 = new int[]{3, -69, -65, 67, -76, 34, 10, 96, 55, 77, 85, 56, 99, -1, 6, -37,
                -7, -70, 75, -60, 4, -73, 35, -32, 3, -7, 72, 83, -82, 70, 68, 63, 33, -68, -100};
        int[] nums2Res = asteroidCollision(nums2);
        //[-69,-65,-76,-100]
        System.out.println("\n" + Arrays.toString(nums2Res));

    }

    public static int[] asteroidCollision(int[] asteroids) {
        int j = 0;

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            while (j > 0 && asteroids[j - 1] > 0 && asteroid < 0 && asteroids[j - 1] < Math.abs(asteroid)) {
                j--;
            }

            if (j == 0 || asteroid > 0 || asteroids[j - 1] < 0)
                asteroids[j++] = asteroid;
            else if (asteroids[j - 1] == Math.abs(asteroid))
                j--;
        }

        int[] result = new int[j];
        System.arraycopy(asteroids, 0, result, 0, j);

        return result;
    }

}
