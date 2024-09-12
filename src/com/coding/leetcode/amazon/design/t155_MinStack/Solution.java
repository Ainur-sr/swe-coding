package com.coding.leetcode.amazon.design.t155_MinStack;

public class Solution {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("min: " + minStack.getMin());
        minStack.pop();
        System.out.println("top: " + minStack.top());
        System.out.println("min: " + minStack.getMin());
    }

}
