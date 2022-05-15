package bintree.leetcode;



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Code144 {
    //递归和迭代实现树的先序遍历

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
//迭代写法
          public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> ret = new ArrayList<>();
                if (root == null) {
                      return ret;
                }
                Deque<TreeNode> stack = new LinkedList<>();
                stack.push(root);
                while(!stack.isEmpty()) {
                      TreeNode node = stack.pop();
                      ret.add(node.val);
                      if (node.right != null) {
                            stack.push(node.right);
                      }
                      if (node.left != null) {
                            stack.push(node.left);
                      }
                }
                return ret;
          }
          //递归写法
//        List<Integer> ret = new ArrayList<>();
//
//        public List<Integer> preorderTraversal(TreeNode root) {
//
//            if (root == null) {
//                return ret;
//            }
//
//            ret.add(root.val);
//
//            preorderTraversal(root.left);
//
//            preorderTraversal(root.right);
//
//            return ret;
//        }
    }
}
