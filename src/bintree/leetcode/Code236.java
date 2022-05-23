package bintree.leetcode;

public class  Code236 {
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

        /*
        *从当前结点开始出发进行后序遍历，同时找到了p和q，且p和q一定出现在两个位置
        *左子树 右子树 根
        *若在左子树中找到1个结点找到一个结点 返回1
        *若在右子树中找到1个结点找到一个结点 返回1
        *根节点就是要找的 返回1
        * 根据这三个变量的和就可以确定lca
         */
        TreeNode lca;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            findNode(root,p,q);
            return lca;
        }
        //从当前以root为根的结点开始出发，能否找到p或者q，找到一个就 true
        public boolean findNode(TreeNode root, TreeNode p,TreeNode q) {
            if (root == null) {
                return false;
            }
            //返回1说明此时从左子树中至少找到了一个结点
            int left = findNode(root.left,p,q) ? 1 : 0;
            //返回1说明在右子树中也找到一个结点
            int right = findNode(root.right,p,q) ? 1 : 0;
            //返回1则说明当前root就是其中一个结点
            int mid = (root == p || root == q) ? 1 : 0;
            //此时p和q出现在以root为根的两个位置，这个root一定是lca
            if (left + right + mid == 2) {
                lca = root;
            }
            //大于0说明至少找到一个结点
            return left + right + mid > 0;
        }
    }
}
