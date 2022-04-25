package seqlist.leetcode;

public class Code0204 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode smallHead = new ListNode();
            ListNode bigHead = new ListNode();
            ListNode smallTail = smallHead;
            ListNode bigTail = bigHead;
            while ( head != null ) {
                if (head.val < x) {
                    smallTail.next = head;
                    smallTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
                head = head.next;
            }
            bigTail.next = null;
            smallTail.next = bigHead.next;
            return smallHead.next;
        }
    }
}
