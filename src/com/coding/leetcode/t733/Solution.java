package com.coding.leetcode.t733;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rowSize = image.length;
        int colSize = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        // arr {row, col}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];

            if (row < 0 || row >= rowSize || col < 0 || col >= colSize) {
                continue;
            }
            if (image[row][col] != oldColor) {
                continue;
            }
            image[row][col] = color;

            queue.offer(new int[]{row + 1, col});
            queue.offer(new int[]{row - 1, col});
            queue.offer(new int[]{row, col + 1});
            queue.offer(new int[]{row, col - 1});
        }

        return image;
    }

}
