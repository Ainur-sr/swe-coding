package com.coding.leetcode.amazon.design.t295_FindMedian;

import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> minQueue;
    private final PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        this.minQueue = new PriorityQueue<>((a, b) -> b - a);
        this.maxQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());

        if (maxQueue.size() < minQueue.size()) {
            maxQueue.offer(minQueue.poll());
        }
    }

    public double findMedian() {
        if (maxQueue.isEmpty()) return 0;

        if (maxQueue.size() > minQueue.size()) return maxQueue.peek();

        return (maxQueue.peek() + minQueue.peek()) / 2.0;
    }

}
