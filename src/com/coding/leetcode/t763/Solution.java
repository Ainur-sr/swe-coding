package com.coding.leetcode.t763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> letterIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            letterIndexMap.put(s.charAt(i), i);
        }

        List<Integer> resList = new ArrayList<>();
        int end = 0;
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, letterIndexMap.get(s.charAt(i)));
            if (end == i) {
                resList.add(size);
                size = 0;
            }
        }

        return resList;
    }

}
