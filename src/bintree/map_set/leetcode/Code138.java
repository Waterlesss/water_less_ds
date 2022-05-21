package bintree.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waterless
 * @Date: 2022/05/20/15:13
 * @Description:复制带随机值指针的链表
 */
public class Code138 {
    public Node copyRadomList(Node head) {
        //1.遍历原链表，构造Map集合，维护原链表和新链表的映射关系
        //原1 = 新1
        Map<Node,Node> map = new HashMap<>();
        for (Node x = head; x != null; x = x.next) {
            Node node = new Node(x.val);
            //原链表的x对应新链表的node
            map.put(x,node);
        }
        //2.再次遍历原链表，通过映射维护新链表的next和radom
        for (Node x = head; x != null; x = x.next) {
            //原1.next = 新3
            //原1.radom = 新3
            //map.get(x).next 原3。next 是通过原链表的映射 得到新链表 get(x.next)是新3
            map.get(x).next = map.get(x.next);
            map.get(x).radom = map.get(x.radom);
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node radom;

    public Node(int val) {
        this.val = val;
    }
}
