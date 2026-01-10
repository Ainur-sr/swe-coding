package com.coding.leetcode.t973;

import java.util.PriorityQueue;

public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] resArr = new int[k][2];
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(x * x + y * y);
            priorityQueue.add(new Point(x, y, distance));
        }

        for (int i = 0; i < k; i++) {
            Point point = priorityQueue.poll();
            resArr[i] = new int[] {point.x, point.y};
        }

        return resArr;
    }

    class Point{
        int x;
        int y;
        double distance;

        public Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
