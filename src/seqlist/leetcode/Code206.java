package seqlist.leetcode;

public class Code206 {
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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode fin = cur.next;
                cur.next = prev;
                prev = cur;
                cur = fin;
            }
            return prev;
        }
    }
//    public ListNode reverseList(ListNode head) {
//        ListNode unrealHead = new ListNode();
//        while (head != null) {
//            ListNode node = new ListNode(head.val);
//            node.next = unrealHead.next;
//            unrealHead.next = node;
//            head = head.next;
//        }
//        return unrealHead.next;
//    }
}
