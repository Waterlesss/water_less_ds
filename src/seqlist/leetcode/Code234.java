package seqlist.leetcode;

public class Code234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null ) {
                return false;
            }
            ListNode cur = head;
            ListNode res = reverseList(head);
            while (cur != null) {
                if (cur.val == res.val) {
                    cur = cur.next;
                    res = res.next;
                } else {
                    return false;
                }
            }
            return true;
        }
        public ListNode reverseList(ListNode head) {
            ListNode unrealHead = new ListNode();
            while (head != null) {
                ListNode node = new ListNode(head.val);
                node.next = unrealHead.next;
                unrealHead.next = node;
                head = head.next;
            }
            return unrealHead.next;
        }
    }
}
