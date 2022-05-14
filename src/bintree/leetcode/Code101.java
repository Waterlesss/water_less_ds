package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Code101 {

    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        //        public boolean isSymmetric(TreeNode root) {
//            if (root == null) {
//                return true;
//            }
//            return isMirror(root.left,root.right);
//
//        }
//
//        public boolean isMirror(TreeNode n1,TreeNode n2) {
//            if (n1 == null && n2 == null) {
//                return true;
//            }
//            if (n1 == null || n2 == null) {
//                return false;
//            }
//            if (n1.val != n2.val) {
//                return false;
//            }
//            return isMirror(n1.left,n2.right) && isMirror(n1.right,n2.left);
//        }
        public boolean isSymmetricNode(TreeNode root) {
            if (root == null) {
                return true;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                if (t1 == null && t2 == null) {
                    continue;
                }
                if (t1 == null || t2 == null) {
                    return false;
                }
                if (t1.val != t2.val) {
                    return false;
                }
                queue.offer(t1.left);
                queue.offer(t2.right);
                queue.offer(t1.right);
                queue.offer(t2.left);
            }
            return true;
        }
    }
}
