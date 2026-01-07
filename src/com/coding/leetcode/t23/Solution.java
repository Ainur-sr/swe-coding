package com.coding.leetcode.t23;

import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.add(lists[i]);
        }

        ListNode head = new ListNode();
        ListNode cur = head;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;

            node = node.next;
            if (node != null) queue.add(node);
        }

        return head.next;
    }


}
