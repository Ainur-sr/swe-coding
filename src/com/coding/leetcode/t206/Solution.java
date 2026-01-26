package com.coding.leetcode.t206;

public class Solution {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(l1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    /**
     * Iterative Approach
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

}
