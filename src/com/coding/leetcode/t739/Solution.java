package com.coding.leetcode.t739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Monotonic Decreasing Stack

        for (int i = 0; i < n; i++) {
            int tI = temperatures[i];
            // Пока стек не пуст и текущая температура больше температуры на вершине стека
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            // Добавляем текущий индекс в стек
            stack.push(i);
        }

        return answer;
    }


}
