package com.algorithm.code.leetcode;

/**
 * leetcode 24
 */
public class SwapPairs {


    static class ListNode {
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

    public static void main(String[] args) {
        ListNode listNode = swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode now = head;
        ListNode mid = head.next;
        now.val ^= mid.val;
        mid.val ^= now.val;
        now.val ^= mid.val;
        while (mid != null && mid.next != null){
            now = mid.next;
            mid = now.next;
            if (mid == null) break;
            now.val ^= mid.val;
            mid.val ^= now.val;
            now.val ^= mid.val;
        }
        return head;
    }


}
