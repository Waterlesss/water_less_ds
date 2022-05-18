package bintree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的基本操作
 */
public class MyBinTree<E> {

    protected TreeNode<Character> root;

    //建立一个测试二叉树
    public void build() {
        TreeNode<Character> node = new TreeNode<>('A');
        TreeNode<Character> node1 = new TreeNode<>('B');
        TreeNode<Character> node2 = new TreeNode<>('C');
        TreeNode<Character> node3 = new TreeNode<>('D');
        TreeNode<Character> node4 = new TreeNode<>('E');
        TreeNode<Character> node5 = new TreeNode<>('F');
        TreeNode<Character> node6 = new TreeNode<>('G');
        TreeNode<Character> node7 = new TreeNode<>('H');
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        node6.right = node7;

        root = node;
    }

    //传入一颗二叉树的根节点 root，就能按照根左右进行输出
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 根
        System.out.print(root.val + " ");
        //左子树的输出交给子函数
        preOrder(root.left);
        //右子树的输出交给子函数
        preOrder(root.right);
    }

    //递归中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

//递归后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);

        postOrder(root.right);

        System.out.print(root.val + " ");
    }

    //迭代层序遍历
    public void levelOrder(TreeNode<E> root) {
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int n =queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode<E> node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    //写一个方法统计当前二叉树中的结点个数
    public int getNodes(TreeNode root) {
        //1.边界条件
//        if (root == null) {
//            return 0;
//        }
//        return 1 + getNodes(root.left) + getNodes(root.right);
        return root == null ? 0 : 1 + getNodes(root.left) + getNodes(root.right);
    }

    //层序遍历统计二叉树的结点个数
    public int getNodesLoop(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int size = 0;
        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return size;
    }


    //统计一个二叉树中叶子节点的个数
    public int getLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodes(root.left) + getLeafNodes(root.right);
    }
    //求当前二叉树中第k层的的结点个数
    public int getLevelNodes(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return  getLevelNodes(root.left,k -1) + getLevelNodes(root.right,k - 1);
    }

    //求二叉树的高度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    //判断一颗指定的二叉树是否包含指定的值val；
    public boolean contains(TreeNode root,E val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        return contains(root.left,val) || contains(root.right,val);
    }


}
class TreeNode<E> {
    //当前结点的值
    E val;
    //左子树的根
    TreeNode<E> left;
    //右子树的根
    TreeNode<E> right;

    public TreeNode(E val) {
        this.val = val;
    }
}