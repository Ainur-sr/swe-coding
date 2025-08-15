package com.coding.leetcode.t295_FindMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinderTwo {

    private PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>();

    public void addNum(int num) {
        // 1) Сначала кладём в minQueue
        minQueue.offer(num);

        // 2) Обеспечим порядок: максимум minQueue должен быть <= минимума maxQueue
        // Если нарушено — перекинем максимум из minQueue в maxQueue
        if (!maxQueue.isEmpty() && minQueue.peek() > maxQueue.peek()) {
            maxQueue.offer(minQueue.poll());
        }

        // 3) Баланс размеров: либо равны, либо minQueue на 1 больше
        if (minQueue.size() - 1 > maxQueue.size()) {
            maxQueue.offer(minQueue.poll());
        } else if (minQueue.size() < maxQueue.size()) {
            minQueue.offer(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.isEmpty()) return 0.0;

        if (minQueue.size() > maxQueue.size()) {
            return (double) minQueue.peek();
        }
        return (minQueue.peek() / 2.0) + (maxQueue.peek() / 2.0);
    }

}
