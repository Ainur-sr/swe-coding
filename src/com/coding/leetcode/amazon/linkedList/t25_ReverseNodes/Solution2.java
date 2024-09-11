package com.coding.leetcode.amazon.linkedList.t25_ReverseNodes;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
        ListNode curr = dummy;
        ListNode nextGroup = dummy;

        while (true) {
            ListNode[] arr = this.getKGroup(nextGroup, k);
            if (arr == null) {
                break;
            }
            nextGroup = new ListNode(0, arr[0].next);

            for (int i = 0; i < k; i++) {
                curr.next = arr[i];
                curr = curr.next;
            }
        }

        if (nextGroup.next != null) {
            curr.next = nextGroup.next;
        }

        return dummy.next;
    }

    private ListNode[] getKGroup(ListNode curr, int k) {
        ListNode[] arr = new ListNode[k];
        while (curr.next != null && k > 0) {
            curr = curr.next;
            arr[k - 1] = curr;
            k--;
        }

        return k > 0 ? null : arr;
    }

}
