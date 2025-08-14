package com.coding.leetcode.t739;

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 3});
        int[] resArr = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];

            while (!stack.isEmpty()) {
                int[] nextTemperature = stack.peek();
                if (nextTemperature[0] <= temperature) {
                    stack.pop();
                } else {
                    resArr[i] = nextTemperature[1] - i;
                    break;
                }
            }

            if (stack.isEmpty()) {
                resArr[i] = 0;
            }
            stack.push(new int[]{temperature, i}); // 1 - value / 2 - index
        }
        return resArr;
    }


}
