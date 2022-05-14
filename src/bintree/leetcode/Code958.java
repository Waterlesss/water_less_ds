package bintree.leetcode;

import bintree.MyBinTree;

import java.util.Deque;
import java.util.LinkedList;

public class Code958 {
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
        public boolean isCompleteTree(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //判断是否是第二阶段
            boolean isSecond = false;
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!isSecond) {
                    //在第一阶段中每个节点都必须存在左右子树
                    if (node.left != null && node.right != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else if (node.left != null) {
                        //此时碰到第一个只有左树没有右树的结点，转阶段
                        queue.offer(node.left);
                        isSecond = true;
                    } else if (node.right != null) {
                        //只有右树没有左树 ，反例
                        return false;
                    } else {
                        //第一个叶子节点，转阶段
                        isSecond =true;
                    }
                }else {
                    //第二阶段，所有节点必须为叶子节点
                    if (node.left != null || node.right != null) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
