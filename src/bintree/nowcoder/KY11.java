package bintree.nowcoder;

import java.util.Scanner;

public class KY11 {
    public static int index = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            //按照先序遍历的方式还原这个二叉树，返回根节点
            TreeNode root = perOrderBuild(str);
            //按照中序遍历的方式输出二叉树的节点值
            inOrder(root);
            System.out.println();
//            index = 0;
        }
    }
//按照中序遍历二叉树，打印节点值
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //传入一个字符串str，就能按照先序遍历的方式还原为二叉树，返回二叉树的根节点
    private static TreeNode perOrderBuild(String str) {
        char cur = str.charAt(index);
        if (cur == '#') {
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        root.left = perOrderBuild(str);
        index++;
        root.right = perOrderBuild(str);
        return root;
    }


}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}