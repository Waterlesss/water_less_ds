package bintree.leetcode;

public class Code106 {
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
     * 给定两个整数数组 inorder 和 postorder ，
     * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
     * 请你构造并返回这颗二叉树。
     */
    class Solution {
        int index = 0;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int[] rePostorder = reverse(postorder);
            return buildTreeHelp( rePostorder, inorder,0,rePostorder.length - 1);
        }
        public int[] reverse(int[] postorder) {
            int length = postorder.length;
            int[] newpostorder = new int[length];
            for (int i = 0; i < length; i++) {
                newpostorder[i] = postorder[length - 1 -i];
            }
            return newpostorder;
        }
        public TreeNode buildTreeHelp(int[] rePreorder, int[] inorder,int left,int right) {

            if (left > right) {
                return null;
            }
            if (index == rePreorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(rePreorder[index]);
            index++;
            int pos = find(inorder,root.val);
            root.right = buildTreeHelp(rePreorder, inorder,pos + 1,right);
            root.left = buildTreeHelp(rePreorder, inorder,left,pos-1);


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
