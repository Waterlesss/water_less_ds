package bintree.leetcode;

/**
 * @Author: Waterless
 * @Date: 2022/05/24/9:48
 * @Description:单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class Code965 {
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return helper(root,root.val);
        }
        public boolean helper(TreeNode root,int val) {
            if (root == null) {
                return true;
            }
            if (root.val != val) {
                return false;
            }
            return helper(root.left,val) && helper(root.right,val);
        }
    }

}
