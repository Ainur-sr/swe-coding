package com.coding.leetcode.t771;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int res = 0;
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                res++;
            }
        }

        return res;
    }

}
