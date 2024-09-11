package com.coding.leetcode.amazon.linkedList.t25_ReverseNodes;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l8 = new ListNode(8);
        ListNode l7 = new ListNode(7, l8);
        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode head = s.reverseKGroup(l1, 3);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kGr = this.getKGroup(groupPrev, k);
            if (kGr == null) {
                break;
            }
            ListNode groupNext = kGr.next; // 4 -> 5 -> 6

            //reverse group
            ListNode prev = kGr.next; // 4
            ListNode curr = groupPrev.next; // 1

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kGr;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private ListNode getKGroup(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}
