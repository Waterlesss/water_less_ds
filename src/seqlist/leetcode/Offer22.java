package seqlist.leetcode;

public class Offer22 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null || k <= 0) {
                return null;
            }
            ListNode fir =head;
            ListNode sec = head;
            int count =0;
            while (fir != null) {
                fir = fir.next;
                count++;
                if (count >= k+ 1) {
                    sec = sec.next;
                }
            }
            return sec;
        }
    }
}
