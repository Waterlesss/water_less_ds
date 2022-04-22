package seqlist.leetcode;

public class Offer18 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {

            if (head == null ) {
                System.out.println("链表为空");
                return head;
            }
            if (head.val == val) {
                ListNode cur =head;
                head = cur.next;
                cur.next = null;

                return head;
            }
            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    ListNode node = prev.next;
                    prev.next = node.next;
                    node.next = null;

                } else {
                    prev = prev.next;
                }
            }
            return head;
        }
    }
}
