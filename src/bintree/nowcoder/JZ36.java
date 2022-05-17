package bintree.nowcoder;

/**
 * @Author: Waterless
 * @Date: 2022/05/17/23:10
 * @Description:
 */
public class JZ36 {
    /**
     * 传入任意一颗树的根节点root，就能将这颗BST转为排序后的双向链表，返回链表的头结点
     * @param pRootOfTree
     * @return
     */


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        //先将左子树转为排序后的双向链表
        TreeNode leftHead = Convert(pRootOfTree.left);
        //找到链表的尾结点和当前的树根拼接
        TreeNode leftTail = leftHead;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        //leftTail走到了尾结点
        //万一左子树是个空树
        if (leftTail != null) {
            //进行拼接
            pRootOfTree.left = leftTail;
            leftTail.right = pRootOfTree;
        }
        //左边已经连接
        //再将右子树也转为双向链表
        TreeNode rightHead = Convert(pRootOfTree.right);
        //拼接
        if (rightHead != null) {
            rightHead.left = pRootOfTree;
            pRootOfTree.right = rightHead;
        }
        return leftHead == null? pRootOfTree : leftHead;
    }
}
