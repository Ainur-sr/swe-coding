package com.coding.leetcode.amazon.graphs.t127_wordLadder;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
/*        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = List.of("hot","dot","dog","lot","log","cog");
        int i = ladderLength(beginWord, endWord, list);
        System.out.println(i);*/

        String beginWord = "hall";
        String endWord = "walk";
        List<String> list = List.of("ball","wall", "walk");
        int i = ladderLength(beginWord, endWord, list);
        System.out.println(i);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String curWord = queue.poll();
                char[] curWordChars = curWord.toCharArray();

                //check word chars
                for (int j = 0; j < curWordChars.length; j++) {
                    char originChar = curWordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (curWordChars[j] == c) continue;
                        curWordChars[j] = c;
                        String newWord = new String(curWordChars);
                        if (newWord.equals(endWord)) {
                            return (step + 1);
                        }
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    curWordChars[j] = originChar;
                }
            }
            step++;
        }
        return 0;    }
}
