package com.coding.leetcode.t63;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] resArr = new int[obstacleGrid.length][obstacleGrid[0].length];
        resArr[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        //fill 1-st row
        for (int c = 1; c < resArr[0].length; c++) {
            if (obstacleGrid[0][c] == 1) {
                resArr[0][c] = 0;
            } else {
                resArr[0][c] = resArr[0][c - 1];
            }
        }

        //fill 1-st column
        for (int r = 1; r < resArr.length; r++) {
            if (obstacleGrid[r][0] == 1) {
                resArr[r][0] = 0;
            } else {
                resArr[r][0] = resArr[r - 1][0];
            }
        }

        for (int r = 1; r < resArr.length; r++) {
            for (int c = 1; c < resArr[0].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    resArr[r][c] = 0;
                } else {
                    resArr[r][c] = resArr[r - 1][c] + resArr[r][c - 1];
                }
            }
        }

        return resArr[resArr.length - 1][resArr[0].length - 1];
    }

}
