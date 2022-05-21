package bintree.mybst;

import javafx.event.EventDispatchChain;

import java.util.NoSuchElementException;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/11:15
 * @Description:
 */
public class MyBinSearchTree {
    private int size;
    Node root;

    public void add(int val) {
        root = add(root, val);
    }

    //向当前以root为根的BST中插入一个新元素value，返回插入后的树根
    private Node add(Node root, int val) {
        if (root == null) {
            //此时树为空，node就是树根
            Node node = new Node(val);
            size++;
            return node;
        }
        if (val < root.val) {
            //此时在左子树插入
            root.left = add(root.left, val);
        }
        if (val > root.val) {
            root.right = add(root.right, val);
        }
        return root;
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    //判断当前以root为根的bst中是否包含指定值val
    private boolean contains(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }else if (val > root.val) {
            return contains(root.right, val);
        } else {
            return contains(root.left, val);
        }
    }

    //先序遍历中找到第一个左子树为空的结点即为最小值
    public int findMin() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty");
        }
        return min(root).val;
    }

    //在以root为根的BST中找到最小值结点
    private Node min(Node root) {
        if (root.left ==null) {
            //这个节点就是第一个碰到的左子树为空的结点
            return root;
        }
        return min(root.left);
    }

    //删除最小值,返回删除前的节点值
    public int removeMin() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty");
        }
        Node minNode = min(root);
        root = removeMin(root);
        return minNode.val;
    }

    //传入一颗以root为根的BST,就能删除其中的最小值。返回删除后的树根根结点
    private Node removeMin(Node root) {
        //边界
        if (root.left == null) {
        //root就是待删除的结点
            Node right = root.right;
            root.right = root = null;
            size--;
            return right;
        }
        //在左子树中删除，更新左子树的引用
        root.left = removeMin(root.left);
        return root;
    }

    //删除最大值,返回删除前的结点值
    public int removeMax() {
        if (size == 0) {
            throw new NoSuchElementException(" BST is empty");
        }
        Node maxNode = max(root);
        root = removeMax(root);
        return maxNode.val;
    }

    private Node removeMax(Node root) {
        //边界
        if (root.right == null) {
            //root就是待删除的结点
            Node left = root.left;
            root.left = root =null;
            size--;
            return left;
        }
        //在右子树中删除，更新右子树的引用
        root.right = removeMax(root.right);
        return root;
    }

    //先序遍历中找到第一个右子树为空的结点即为最大值
    public int findMax() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty");
        }
        return max(root).val;
    }

    //在以root为根的BST中找到最大值结点
    private Node max(Node root) {
        if (root.right == null) {
            //这个节点就是第一个碰到的右子树为空的结点
            return root;
        }
        return max(root.right);
    }

    //删除任意val
    public void remove(int val){
        if (size == 0) {
            throw new NoSuchElementException("BST is empty");
        }
        root = remove(root,val);
    }

    //在当前以root为根的BST中删除值为val的结点，返回删除后新树根的结点
    private Node remove(Node root, int val) {
        if (root == null) {
            //没找到值为val的结点
            throw new NoSuchElementException("BST do not has this val");
        } else if (val < root.val) {
            //在左子树中删除
            root.left = remove(root.left,val);
            return root;
        }else if (val > root.val) {
            //在右子树中删除
           root.right = remove(root.right,val);
           return root;
        } else{
            //树不为空且 root.val == val 当前root就是要删除的结点
            if (root.left == null) {
                //左树为空，类似于删除最小值，返回右子树的树根
                Node right = root.right;
                root.right = root = null;
                size--;
                return right;
            }
            if (root.right == null) {
                //右树为空，类似于删除最大值，返回左子树的树根
                Node left = root.left;
                root.left = root = null;
                size--;
                return left;
            }
            //待删除结点左右子树都不为空，Hibbard Deletion
            //找到当前root的前驱(左子树的最大值)或者后继结点，这里找后继(右子树的最小值)
            Node successor =min(root.right);
            //1.先在右子树中删除这个节点
            successor.right = removeMin(root.right);
            //2.连接root.left
            successor.left = root.left;
            //gc
            root.left = root.right = root =null;
            return successor;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    //按照先序遍历的方式，将BST的节点值存入到sb之中
    private void generateBSTString(Node root, int height, StringBuilder sb) {
        //边界
        if (root == null) {
            sb.append(generateHeightStr(height)).append("NULL\n");
            return;
        }
        sb.append(generateHeightStr(height)).append(root.val).append("\n");
        //递归打印左子树
        generateBSTString(root.left,height + 1,sb);
        //递归打印右子树
        generateBSTString(root.right,height + 1,sb);
    }

    //按照当前结点的高度打印 --
    //树根不打印
    //第一层-
    //第二层--
    private String generateHeightStr(int height) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}