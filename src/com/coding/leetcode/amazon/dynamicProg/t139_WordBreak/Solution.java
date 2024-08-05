package com.coding.leetcode.amazon.dynamicProg.t139_WordBreak;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code"))); //true
        System.out.println(solution.wordBreak("applepenapple", List.of("apple","pen"))); //true
        System.out.println(solution.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"))); //false
        System.out.println(solution.wordBreak("aaaaaaa", List.of("aaaa", "aaa"))); //true
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int minWordLen = Integer.MAX_VALUE;
        for (String w : wordDict) {
            dict.add(w);
            if (w.length() < minWordLen) {
                minWordLen = w.length();
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int startIdx = queue.poll();
            if (visited.contains(startIdx)) {
                continue;
            } else {
                visited.add(startIdx);
            }

            for (int lastIdx = (startIdx + minWordLen - 1); lastIdx < s.length(); ) {
                String curWord = s.substring(startIdx, lastIdx + 1);
                if (dict.contains(curWord)) {
                    int newStartIdx = startIdx + curWord.length();
                    if (newStartIdx >= s.length()) {
                        return true;
                    }
                    queue.add(newStartIdx);
                }
                lastIdx++;
            }
        }
        return false;
    }

}
