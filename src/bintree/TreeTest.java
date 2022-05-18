package bintree;

public class TreeTest {
    public static void main(String[] args) {
        MyBinTree binTree = new MyBinTree();
        binTree.build();
        System.out.println("层序遍历：");
        binTree.levelOrder(binTree.root);
        System.out.println();
        System.out.println("结点个数为：");
        System.out.println(binTree.getNodesLoop(binTree.root));
//        System.out.println("前序遍历：");
//        binTree.preOrder(binTree.root);
//        System.out.println();
//        System.out.println("中序遍历：");
//        binTree.inOrder(binTree.root);
//        System.out.println();
//        System.out.println("后序遍历：");
//        binTree.postOrder(binTree.root);
//        System.out.println();
//        System.out.println("当前二叉树中结点的个数为：" + binTree.getNodes(binTree.root));
//        System.out.println("叶子节点个数：" + binTree.getLeafNodes(binTree.root));
//        System.out.println("第三层的结点个数为：" + binTree.getLevelNodes(binTree.root,3));
//        System.out.println("当前二叉树的高度为：" +binTree.height(binTree.root));
//        System.out.println(binTree.contains(binTree.root,'i'));
    }
}
