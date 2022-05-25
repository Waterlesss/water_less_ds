package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Waterless
 * @Date: 2022/05/25/9:32
 * @Description:
 */
public class Code1028 {
    public static void main(String[] args) {
        Code1028 code1028 = new Code1028();
        code1028.recoverFromPreorder("1-2--3--4-5--6--7");

    }
    public TreeNode recoverFromPreorder(String S) {
        String[] valus = S.split("-");
        List<TreeNode> list = new ArrayList<>();
        //根节点添加到list中
        list.add(new TreeNode(Integer.parseInt(valus[0])));
        int level = 1;
        for (int i = 1; i < valus.length; i++) {
            if (!valus[i].isEmpty()) {
                TreeNode node = new TreeNode(Integer.parseInt(valus[i]));
                //因为是前序遍历，每层我们只需要存储一个结点即可，这个节点值有可能
                //会被覆盖，如果被覆盖了说明这个节点以及他的子节点都以及遍历过了，
                //所以我们不用考虑被覆盖问题
                list.add(level, node);
                //获取父节点
                TreeNode parent = list.get(level - 1);
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                //重新赋值
                level = 1;
            } else {
                //加一层
                level++;
            }
        }
        return list.get(0);
    }
}
