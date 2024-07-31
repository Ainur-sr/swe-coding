package com.coding.leetcode.amazon.ArraysAndStrings.t49_GroupAnagrams;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(getHash("eat"));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            String hashKey = getHash(s);

            if (!hashMap.containsKey(hashKey)) {
                hashMap.put(hashKey, new ArrayList<>());
            }
            hashMap.get(hashKey).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

    private static String getHash(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append('#');
            sb.append(count[i]);
        }
        return sb.toString();
    }
}
