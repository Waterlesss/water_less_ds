package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Code94 {

    //       Definition for a binary tree node.
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
        //递归写法
        //        List<Integer> ret = new ArrayList<>();
//        public List<Integer> inorderTraversal(TreeNode root) {
//            if (root == null) {
//                return ret;
//            }
//            inorderTraversal(root.left);
//            ret.add(root.val);
//            inorderTraversal(root.right);
//            return ret;
//        }
        //迭代写法
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) {
                return ret;
            }
            Deque<TreeNode> stack = new LinkedList<>();
                TreeNode node = root;
                while (node != null || !stack.isEmpty()) {
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                    node = stack.pop();
                    ret.add(node.val);
                    node = node.right;
                }
            return ret;
        }
    }
}
