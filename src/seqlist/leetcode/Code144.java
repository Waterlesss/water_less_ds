package seqlist.leetcode;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Code144 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {


        List<Integer> ret = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {

            if (root == null) {
                return ret;
            }

            ret.add(root.val);

            preorderTraversal(root.left);

            preorderTraversal(root.right);

            return ret;
        }
    }
}
