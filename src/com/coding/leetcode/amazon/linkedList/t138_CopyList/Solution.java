package com.coding.leetcode.amazon.linkedList.t138_CopyList;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            Map<Node, Node> oldToCopyMap = new HashMap<>();

            Node cur = head;
            while (cur != null) {
                Node copy = new Node(cur.val);
                oldToCopyMap.put(cur, copy);
                cur = cur.next;
            }

            cur = head;
            while (cur != null) {
                Node copy = oldToCopyMap.get(cur);
                copy.next = oldToCopyMap.get(cur.next);
                copy.random = oldToCopyMap.get(cur.random);
                cur = cur.next;
            }

            return oldToCopyMap.get(head);
        }

    }

}
