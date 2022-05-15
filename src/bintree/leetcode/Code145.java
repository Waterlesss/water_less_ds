package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历
 */
public class Code145 {

//       Definition for a binary tree node.
       public class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode() {}
           TreeNode(int val) { this.val = val; }
           TreeNode(int val, TreeNode left, TreeNode right) {
               this.val = val;
               this.left = left;
               this.right = right;
           }
       }

    class Solution {
           //迭代写法
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) {
                return ret;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            TreeNode prev = null;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node .left;
                }
                node = stack.pop();
                if (node.right == null || prev == node.right) {
                    ret.add(node.val);
                    prev = node;
                    node =null;
                } else {
                    stack.push(node);
                    node= node.right;
                }
            }
            return ret;
        }
        //递归写法
//        List<Integer> ret = new ArrayList<>();
//        public List<Integer> postorderTraversal(TreeNode root) {
//            if (root == null) {
//                return ret;
//            }
//            postorderTraversal(root.left);
//            postorderTraversal(root.right);
//            ret.add(root.val);
//            return ret;
//        }
    }
}
