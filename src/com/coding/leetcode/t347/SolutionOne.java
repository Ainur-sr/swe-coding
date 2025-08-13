package com.coding.leetcode.t347;

import java.util.*;
import java.util.stream.Stream;

public class SolutionOne {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        int[] result = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // min-heap по freq
        for (var e : freq.entrySet()) {
            pq.offer(new int[]{e.getValue(), e.getKey()});
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[1]; // порядок не важен
        }
        return res;
    }


}
