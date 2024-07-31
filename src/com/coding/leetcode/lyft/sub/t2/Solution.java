package com.coding.leetcode.lyft.sub.t2;

import com.coding.leetcode.t2.ListNode;

public class Solution {

    public static void main(String[] args) {
        int x = 8 / 10;
        System.out.println(x);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int extra = 0;


        while (l1 != null || l2 != null) {
            int sum = extra;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            extra = sum / 10;
        }

        if (extra != 0) {
            cur.next = new ListNode(extra);
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
