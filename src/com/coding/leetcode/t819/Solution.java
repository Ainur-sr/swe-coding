package com.coding.leetcode.t819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freqMap = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s.toLowerCase());
        }

        int maxFreq = 0;
        String maxFreqWord = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= paragraph.length(); i++) {
            char ch = ' ';
            if (i < paragraph.length()) {
                ch = paragraph.charAt(i);
            }

            if (Character.isLetter(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                String word = sb.toString();
                if (!sb.isEmpty() && !bannedSet.contains(word)) {
                    Integer count = freqMap.get(word);
                    if (count == null) {
                        count = 1;
                    } else {
                        count++;
                    }
                    freqMap.put(word, count);
                    if (maxFreq < count) {
                        maxFreq = count;
                        maxFreqWord = word;
                    }
                }
                sb.setLength(0);
            }
        }

        return maxFreqWord;
    }

}
