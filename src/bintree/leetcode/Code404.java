package seqlist.leetcode;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class Code404 {

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

        public int sumOfLeftLeaves(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int sum = 0;

            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum = sum + root.left.val;
            }

            return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
