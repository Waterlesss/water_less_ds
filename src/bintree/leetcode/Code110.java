package bintree.leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Code110 {

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
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(height(root.left),height(root.right));
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int abs = Math.abs(leftHeight - rightHeight);
            return abs <=1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
}
