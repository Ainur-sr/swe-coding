package com.coding.leetcode.epam.t20;

import java.util.Stack;

public class Solution {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character p = stack.pop();
                if (c == ')' && p != '(') {
                    return false;
                } else if (c == '}' && p != '{') {
                    return false;
                } else if (c == ']' && p != '[') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
