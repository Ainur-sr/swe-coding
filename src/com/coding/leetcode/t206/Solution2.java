package com.coding.leetcode.t206;

public class Solution2 {

    /**
     * Recursive Approach
     */
    public ListNode reverseList(ListNode head) {
        System.out.println(head.val);
        // Базовый случай: пустой список или один элемент
        if (head == null || head.next == null) {
            return head;
        }

        // Рекурсивно разворачиваем остаток списка
        // newHead будет указывать на последний элемент (новую голову)
        ListNode newHead = reverseList(head.next);

        // Разворачиваем связь: следующий узел теперь указывает на текущий
        head.next.next = head;

        // Текущий узел становится последним, поэтому его next = null
        head.next = null;

        return newHead;
    }

}
