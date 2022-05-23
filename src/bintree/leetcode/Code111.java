package bintree.leetcode;

/**
 * @Author: Waterless
 * @Date: 2022/05/23/11:28
 * @Description:给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class Code111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null & root.right == null) {
                return 1;
            }
            int leftMin = minDepth(root.left);
            int rightMin = minDepth(root.right);
            if (root.left == null || root.right == null) {
                return 1 + leftMin + rightMin;
            }
            return 1 + Math.min(leftMin,rightMin);
        }
    }
}
