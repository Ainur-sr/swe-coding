package com.coding.leetcode.amazon.linkedList.t23_MergekSortedLists;

import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode head = new ListNode();
        ListNode cur = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;

        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
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
