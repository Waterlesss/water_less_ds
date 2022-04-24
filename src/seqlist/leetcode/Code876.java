package seqlist.leetcode;

public class Code876 {
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
        public ListNode middleNode(ListNode head) {
            if (head.next == null) {
                return head;
            }
            int count = 1;
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                cur = cur.next;
                count++;
            }
            ListNode mid = head;
            for (int i = 0;i < count/2;i++ ) {
                mid = mid.next;
            }
            return mid;
        }
    }
}
