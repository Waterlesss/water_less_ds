package seqlist.leetcode;

public class Code82 {
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode unrealHead = new ListNode();
            ListNode cur = head;
            unrealHead.next = head;
            ListNode tmp = unrealHead;
            while (cur != null) {
                if (cur.next != null && cur.val == cur.next.val) {
                    while (cur.next != null && cur.val == cur.next.val) {
                        cur = cur.next;
                    }
                    cur = cur.next;
                } else {
                    tmp.next = cur;
                    cur = cur.next;
                    tmp = tmp.next;
                }
            }
            tmp.next = null;
            return unrealHead.next;
        }
    }
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode unrealHead = new ListNode(-1,head);
//        ListNode prev = unrealHead;
//        ListNode cur = prev.next;
//
//        while (cur != null) {
//            ListNode next = cur.next;
//            if (next == null) {
//                break;
//            } else {
//                if (next != null && cur.val != next.val) {
//                    prev = prev.next;
//                    cur = cur.next;
//                    next = next.next;
//
//                } else {
//                    while (next != null && cur.val == next.val) {
//                        next = next.next;
//                    }
//                    prev.next = next;
//                    cur = next;
//
//                }
//            }
//        }return unrealHead.next;
//    }
}
