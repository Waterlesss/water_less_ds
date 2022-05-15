package bintree.leetcode;

public class Code236 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        TreeNode lca;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            findNode(root,p,q);
            return lca;
        }
        public boolean findNode(TreeNode root, TreeNode p,TreeNode q) {
            if (root == null) {
                return false;
            }
            int left = findNode(root.left,p,q) ? 1 : 0;
            int right = findNode(root.right,p,q) ? 1 : 0;
            int mid = (root == p || root == q) ? 1 : 0;
            if (left + right + mid == 2) {
                lca = root;
            }
            return left + right + mid > 0;
        }
    }
}
