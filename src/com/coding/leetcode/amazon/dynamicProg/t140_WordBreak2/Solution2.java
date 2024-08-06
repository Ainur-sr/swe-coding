package com.coding.leetcode.amazon.dynamicProg.t140_WordBreak2;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
//        System.out.println(sol.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
        // ["cats and dog", "cat sand dog"]

//        System.out.println(sol.wordBreak("a", List.of("a")));
        // ["a"]

//        System.out.println(sol.wordBreak("ab", List.of("a", "b")));
        // ["a b"]

        System.out.println(sol.wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple")));
        // ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0));

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int l = node.lasIdx;
            int r = l;

            while (r < s.length()) {
                String sub = s.substring(l, r + 1);

                if (wordSet.contains(sub)) {
                    if (r == s.length() - 1) {
                        if (node.sb == null) {
                            result.add(sub);
                        } else {
                            node.sb.append(" ").append(sub);
                            result.add(node.sb.toString());
                        }
                    } else if (node.sb == null) {
                        Node newNode = new Node(new StringBuilder(sub), r + 1);
                        queue.offer(newNode);
                    } else {
                        StringBuilder newSB = new StringBuilder(node.sb);
                        newSB.append(" ").append(sub);
                        queue.offer(new Node(newSB, r + 1));
                    }
                }
                r++;
            }
        }

        return result;
    }


    class Node {
        StringBuilder sb = null;
        Integer lasIdx;

        public Node() {
        }

        public Node(Integer lasIdx) {
            this.lasIdx = lasIdx;
        }
        public Node(StringBuilder sb, Integer lasIdx) {
            this.sb = sb;
            this.lasIdx = lasIdx;
        }
    }

}
