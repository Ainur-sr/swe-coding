package com.coding.leetcode.t131;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.partition("aab");
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> resList = new ArrayList<>();
        List<String> curList = new ArrayList<>();

        backtrack(s, 0, resList, curList);

        return resList;
    }

    private void backtrack(String s, int start, List<List<String>> resList, List<String> curList){
        if (start >= s.length()) {
            resList.add(new ArrayList<>(curList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                curList.add(s.substring(start, end));
                backtrack(s, end, resList, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
