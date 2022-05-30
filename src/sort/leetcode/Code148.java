package sort.leetcode;

import seqlist.leetcode.ListNode;

/**
 * @Author: Waterless
 * @Date: 2022/05/30/14:09
 * @Description: leetcode 148 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Code148 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    /**
     * 传入一个一head为头结点的链表，就能把他排序，返回排序后的链表头结点
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找到链表的中间节点，拆分
        ListNode mid = middle(head);
        ListNode x = head;
        while (x.next != mid) {
            x = x.next;
        }
        //x.next = mid x就是中间节点的前驱，第一个链表的尾节点
        x.next = null;
        //先把左右两个子链表排好序
        ListNode l1 =  sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1,l2);
    }

    /**
     * 传入两个有序的子链表l1，l2就能合并为一个打的有序链表，返回链表的头结点
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        //递归法
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        if (l1.val < l2.val) {
//            l1.next = merge(l1.next,l2);
//            return l1;
//        } else {
//            l2.next = merge(l1,l2.next);
//            return l2;
//        }
        //迭代法
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummyHead.next;
    }

    private ListNode middle(ListNode head) {
        ListNode fir = head,sec = head;
        while (fir != null && fir.next != null) {
            fir = fir.next.next;
            sec = sec.next;
        }
        //当fir走到空，sec就是中间节点
        return sec;
    }
}
