package com.coding.leetcode.lyft.t735;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {

    public static void main(String[] args) {
/*        int[] nums2 = new int[]{3, -69, -65, 67, -76, 34, 10, 96, 55, 77, 85, 56, 99, -1, 6, -37,
                -7, -70, 75, -60, 4, -73, 35, -32, 3, -7, 72, 83, -82, 70, 68, 63, 33, -68, -100};
        int[] nums2Res = asteroidCollision(nums2);
        //[-69,-65,-76,-100]
        System.out.println("\n" + Arrays.toString(nums2Res));*/


        int[] nums3 = new int[]{8, -8};
        int[] nums3Res = asteroidCollision(nums3);
        //[]
        System.out.println("\n" + Arrays.toString(nums3Res));

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (stack.empty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = stack.pop();
        }
        return res;
    }

}
