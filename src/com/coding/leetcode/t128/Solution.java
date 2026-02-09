package com.coding.leetcode.t128;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        int longest = 0;

        for (int n : numSet) {
            // check if its the start of a sequence
            if (!numSet.contains(n - 1)) {
                int len = 0;
                while (numSet.contains(n + len)) {
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }

        return longest;
    }

}
