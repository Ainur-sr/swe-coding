package com.coding.leetcode.t480;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int[] nums = new int[]{1, 4, 2, 3};
        double[] doubles = solution.medianSlidingWindow(nums, 4);
        System.out.println(Arrays.toString(doubles));
    }

    private PriorityQueue<Integer> minQ;
    private PriorityQueue<Integer> maxQ;
    private int minSize;
    private int maxSize;
    private int k;
    private Map<Integer, Integer> toRemoveMap;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0 || nums.length < k) {
            return new double[0];
        }

        this.minQ = new PriorityQueue<>(Comparator.reverseOrder());
        this.maxQ = new PriorityQueue<>();
        this.minSize = 0;
        this.maxSize = 0;
        this.k = k;
        this.toRemoveMap = new HashMap<>();
        double[] res = new double[nums.length - k + 1];

        //first window
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        res[0] = getMedian();

        //next windows
        for (int i = k; i < nums.length; i++) {
            int n = nums[i];
            addNum(n);
            removeNum(nums[i - k]);
            res[i - k + 1] = getMedian();
        }
        return res;
    }

    private void addNum(int num) {
        if (minQ.isEmpty() || minQ.peek() >= num) {
            minQ.offer(num);
            minSize++;
        } else {
            maxQ.offer(num);
            maxSize++;
        }
        balance();
    }

    private void removeNum(int n) {
        toRemoveMap.put(n, toRemoveMap.getOrDefault(n, 0) + 1);

        if (!minQ.isEmpty() && minQ.peek() >= n) {
            minSize--;
            if (!minQ.isEmpty() && Objects.equals(minQ.peek(), n)) {
                prune(minQ);
            }
        } else {
            maxSize--;
            if (!maxQ.isEmpty() && Objects.equals(maxQ.peek(), n)) {
                prune(maxQ);
            }
        }
        balance();
    }

    private void balance() {
        if (minSize - 1 > maxSize) {
            maxQ.offer(minQ.poll());
            minSize--;
            maxSize++;
            prune(minQ);
        } else if (minSize < maxSize) {
            minQ.offer(maxQ.poll());
            maxSize--;
            minSize++;
            prune(maxQ);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            Integer p = heap.peek();
            Integer cnt = toRemoveMap.get(p);
            if (cnt == null || cnt == 0) break;
            heap.poll();

            if (cnt == 1)
                toRemoveMap.remove(p);
            else
                toRemoveMap.put(p, cnt - 1);
        }
    }

    private double getMedian() {
        if (k % 2 == 1)
            return (double) minQ.peek();
        else
            return ((double) minQ.peek() + (double) maxQ.peek()) / 2.0;
    }

}
