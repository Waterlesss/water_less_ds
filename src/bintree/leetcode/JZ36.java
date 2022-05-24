package bintree.leetcode;

/**
 * @Author: Waterless
 * @Date: 2022/05/24/21:10
 * @Description:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 链表的头和尾也要连起来
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

}
public class JZ36 {
    class Solution {
        Node head;
        Node prev;
        public Node treeToDoublyList(Node root) {
            if(root == null) {
                return null;
            }
            dfs(root);
            head.left = prev;
            prev.right = head;
            return head;
        }
        public void dfs(Node root) {
            if (root == null) {
                return ;
            }
            dfs(root.left);
            root.left = prev;
            if (prev == null) {
                head = root;
            } else {
                prev.right = root;
            }
            prev = root;
            dfs(root.right);
        }
    }
}
