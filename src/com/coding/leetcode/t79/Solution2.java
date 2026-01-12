package com.coding.leetcode.t79;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isBlank()) {
            return false;
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                boolean isExist = dfs(board, word, new HashSet<>(), r, c, 0);
                if (isExist) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, Set<String> path, int r, int c, int curInd) {
        if (curInd == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length) {
            return false;
        }
        if (c < 0 || c >= board[0].length){
            return false;
        }
        String key = r + "-" + c;
        if (path.contains(key)){
            return false;
        }
        if (board[r][c] != word.charAt(curInd)){
            return false;
        }
        path.add(key);
        boolean res = dfs(board, word, path, r + 1, c, curInd + 1)
                || dfs(board, word, path, r - 1, c, curInd + 1)
                || dfs(board, word, path, r, c + 1, curInd + 1)
                || dfs(board, word, path, r, c - 1, curInd + 1);

       path.remove(key);

       return res;
    }

}
