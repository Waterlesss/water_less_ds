package seqlist.leetcode;

public class Code142 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head,slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode mid = head;
                    while (mid != slow) {
                        mid = mid.next;
                        slow = slow.next;
                    }
                    return mid;
                }
            }
            return null;
        }
    }
}
