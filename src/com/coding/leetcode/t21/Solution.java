package com.coding.leetcode.t21;

public class Solution {

    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a head node to simplify edge cases
        ListNode head = new ListNode(0);
        ListNode current = head;

        // Traverse both lists and compare values
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
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
