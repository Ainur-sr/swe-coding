package com.coding.leetcode.amazon.linkedList.t206_ReverseLinkedList;

public class Solution {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        Solution solution = new Solution();
        ListNode listNode = solution.reverseList2(l1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head;
        ListNode nextNode = head.next;
        curNode.next = null;

        while (nextNode != null) {
            ListNode tmp = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
            curNode.next = tmp;
        }

        return curNode;
    }

}
