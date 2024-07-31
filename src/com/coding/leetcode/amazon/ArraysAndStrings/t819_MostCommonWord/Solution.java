package com.coding.leetcode.amazon.ArraysAndStrings.t819_MostCommonWord;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "Bob. hIt, baLl";

        String e = mostCommonWord(s, new String[]{"bob", "hit"});
        System.out.println(e);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        char[] charArray = paragraph.toLowerCase().toCharArray();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                String word = sb.toString();
                if (word != null && !word.isBlank() && !set.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
                sb.setLength(0);
            }
        }
        if (!sb.isEmpty()) {
            String word = sb.toString();
            if (word != null && !word.isBlank() && !set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String maxWord = null;
        if (!map.isEmpty()) {
            Iterator<String> iterator = map.keySet().iterator();
            maxWord = iterator.next();
            int wordCount = map.get(maxWord);

            while (iterator.hasNext()) {
                String word = iterator.next();
                int count = map.get(word);
                if (count > wordCount) {
                    maxWord = word;
                    wordCount = count;
                }
            }
        }

        return maxWord;
    }

}
