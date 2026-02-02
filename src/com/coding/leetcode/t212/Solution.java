package com.coding.leetcode.t212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    class Trie {
        public Map<Character, Trie> children;
        public boolean isWord;
        public int refs = 0;

        public Trie() {
            children = new HashMap<>();
        }

        public void addWord(String word) {
            Trie node = this;
            node.refs++;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node.children.putIfAbsent(ch, new Trie());
                node = node.children.get(ch);
                node.refs++;
            }

            node.isWord = true;
        }

        public void removeWord(String word) {
            Trie node = this;
            node.refs--;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                    node.refs--;
                }
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        Set<String> result = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, new StringBuilder(), result, root);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int row, int col, Trie node,
                     StringBuilder strBuilder, Set<String> result, Trie root) {
        // Проверка границ
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        // Проверка посещенных клеток и наличия в Trie
        if (ch == '#' || !node.children.containsKey(ch)) {
            return;
        }

        Trie next = node.children.get(ch);

        // PRUNING: если refs < 1, все слова через эту ветку уже найдены
        if (next.refs < 1) {
            return;
        }

        // Переходим к следующему узлу
        strBuilder.append(ch);

        // Нашли слово
        if (next.isWord) {
            String found = strBuilder.toString();
            result.add(found);
            next.isWord = false;

            // Используем метод removeWord для декремента refs
            root.removeWord(found);
        }

        // Помечаем клетку как посещенную
        board[row][col] = '#';

        // DFS в 4 направлениях
        dfs(board, row - 1, col, next, strBuilder, result, root);
        dfs(board, row + 1, col, next, strBuilder, result, root);
        dfs(board, row, col - 1, next, strBuilder, result, root);
        dfs(board, row, col + 1, next, strBuilder, result, root);

        // Backtracking
        board[row][col] = ch;
        strBuilder.deleteCharAt(strBuilder.length() - 1);
    }

}

