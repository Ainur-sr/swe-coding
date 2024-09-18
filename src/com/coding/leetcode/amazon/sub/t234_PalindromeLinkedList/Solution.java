package com.coding.leetcode.amazon.sub.t234_PalindromeLinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(solution.isPalindrome(l1));
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode median = findMedian(head);
        ListNode secondHead = reverse(median);

        ListNode left = head;
        ListNode right = secondHead;

        while (right != null) {
            if (right.val != left.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode findMedian(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }


    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = tmp;
        }

        return prev;
    }

}
