package seqlist.leetcode;

public class ListNode {
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

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        } else {
            ListNode res = head;
            while (res.next != null) {
                if (res.next.val == val) {
                    ListNode node = res.next;
                    res.next = node.next;

                } else {
                    res = res.next;
                }
            }
            return head;
        }
    }
}