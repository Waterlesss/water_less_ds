package bintree.leetcode;

public class Code572 {
    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
     *
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     */
//    class Solution {
//        public boolean isSameTree(TreeNode p, TreeNode q) {
//            if (p == null && q == null) {
//                return true;
//            }
//            if (p== null || q == null) {
//                return false;
//            }
//            return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
//        }
//        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//            if (root == null && subRoot == null ) {
//                return true;
//            }
//            if (root == null || subRoot == null) {
//                return false;
//            }
//            return isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
//        }
//    }
}
