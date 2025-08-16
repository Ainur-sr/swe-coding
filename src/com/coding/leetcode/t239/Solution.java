package com.coding.leetcode.t239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] resArr = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); //for indexes

        int l = 0;
        int r = 0;
        while (r < nums.length) {
            //remove smaller value from deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]){
                 deque.pollLast();
            }
            deque.offerLast(r);

            //remove left value from deque
            if (!deque.isEmpty() && l > deque.peekFirst()) {
                deque.pollFirst();
            }

            if (r + 1 >= k) {
                resArr[l] = nums[deque.peekFirst()];
                l++;
            }
            r++;
        }

        return resArr;
    }
}
