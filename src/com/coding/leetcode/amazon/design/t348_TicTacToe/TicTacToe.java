package com.coding.leetcode.amazon.design.t348_TicTacToe;

public class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int intPlayer = player == 1 ? 1 : -1;

        rows[row] += intPlayer;
        cols[col] += intPlayer;

        if (row == col) {
            diagonal += intPlayer;
        }
        if (row == (n - 1 - col)) {
            antiDiagonal += intPlayer;
        }

        if (Math.abs(rows[row]) == n
                || Math.abs(cols[row]) == n
                || Math.abs(diagonal) == n
                || Math.abs(antiDiagonal) == n
        ) {
            return player;
        }

        return 0;
    }

}
