package bintree.leetcode;


import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Code105 {

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

    /**
     * 给定两个整数数组preorder 和 inorder，
     * 其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，
     * 请构造二叉树并返回其根节点。

     */
    class Solution {
        int index = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return buildTreeHelp( preorder, inorder,0,inorder.length - 1);
        }
        public TreeNode buildTreeHelp(int[] preorder, int[] inorder,int left,int right) {

            if (left > right) {
                return null;
            }
            if (index == preorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[index]);
            index++;
            int pos = find(inorder,root.val);

            root.left = buildTreeHelp(preorder, inorder,left,pos-1);

            root.right = buildTreeHelp(preorder, inorder,pos + 1,right);
            return root;

        }
        public int find (int[] inorder, int val) {
            for (int i = 0; i < inorder.length;i++) {
                if (inorder[i] == val) {
                    return i;
                }

            }
            return -1;
        }
    }
}
