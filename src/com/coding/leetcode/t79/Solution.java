package com.coding.leetcode.t79;

public class Solution {

    public static void main(String[] args) {
/*        //test 1
        char[][] board1 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean test1 = exist(board1, "ABCCED"); // true
        System.out.println(test1);*/

/*        //test 2
        char[][] board2 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean test2 = exist(board2, "ABCB"); // false
        System.out.println(test2);*/

        //test 3
        char[][] board3 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean test3 = exist(board3, "ABCESEEEFS"); // true
        System.out.println(test3);

    }

    public static boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, r, c, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int rowInd, int colInd, boolean[][] visited, int letInd) {
        visited[rowInd][colInd] = true;
        if (letInd == word.length() - 1) {
            return true;
        }
        int nextLetInd = letInd + 1;
        int rowSize = board.length;
        int colSize = board[0].length;

        //up
        if (rowInd > 0 && visited[rowInd - 1][colInd] == false && board[rowInd - 1][colInd] == word.charAt(nextLetInd)) {
            boolean result = dfs(board, word, rowInd - 1, colInd, visited, nextLetInd);
            if (result) return true;
        }

        //down
        if (rowInd < rowSize - 1 && visited[rowInd + 1][colInd] == false &&  board[rowInd + 1][colInd] == word.charAt(nextLetInd)) {
            boolean result = dfs(board, word, rowInd + 1, colInd, visited, nextLetInd);
            if (result) return true;
        }

        //right
        if (colInd < colSize - 1 && visited[rowInd][colInd + 1] == false && board[rowInd][colInd + 1] == word.charAt(nextLetInd)) {
            boolean result = dfs(board, word, rowInd, colInd + 1, visited, nextLetInd);
            if (result) return true;
        }

        //left
        if (colInd > 0 && visited[rowInd][colInd - 1] == false && board[rowInd][colInd - 1] == word.charAt(nextLetInd)) {
            boolean result = dfs(board, word, rowInd, colInd - 1, visited, nextLetInd);
            if (result) return true;
        }
        visited[rowInd][colInd] = false;
        return false;
    }
}
