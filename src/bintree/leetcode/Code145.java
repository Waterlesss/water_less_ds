package bintree.leetcode;

import java.util.ArrayList;
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
        List<Integer> ret = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return ret;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            ret.add(root.val);
            return ret;
        }
    }
}
