package hash;

import java.util.NoSuchElementException;

/**
 * @Author: Waterless
 * @Date: 2022/05/22/15:42
 * @Description:
 */
public class MyHashMap {
    //有效结点的个数
    private int size;
    //实际存储元素的Node数组
    private Node[] hashTable;

    //取模数
    public int M;

    //负载因子
    private static final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int init) {
        this.hashTable = new Node[init];
        this.M = init;
    }

    //对key求哈希
    public int hash(int key) {
        return Math.abs(key) % M;
    }

    //将一对键值对保存到当前的哈希表中，若key存在，修改原来的键值对，返回修改前的元素
    public int put(int key,int val) {
        //1.先对key取模;求出当前结点要保存的索引
        int index = hash(key);
        //2.遍历这个index对应的链表，查看key是否存在；若包含，更新value,没有新增
        for (Node x = hashTable[index]; x != null; x = x.next) {
            if (x.key == key) {
                int oldVal = x.value;
                x.value = val;
                return oldVal;
            }
        }
        //3.此时整个链表中不包含相应key结点，头插到当前位置
        Node node = new Node(key,val);
        //当前链表的头结点就是：hashTable[index];
        node.next = hashTable[index];
        hashTable[index] = node;
        size++;
        //添加元素之后判断是否需要扩容
        if (size >= hashTable.length * LOAD_FACTOR) {
            resize();
        }
        return val;
    }

    //判断当前key值是否在表中存在
    public boolean containsKey(int key) {
        int index = hash(key);
        for (Node x = hashTable[index]; x != null; x = x.next) {
            if (x.key == key) {
                return true;
            }
        }
        return false;
    }

    //查找value是否存在
    public boolean containsValue (int value) {
        //没有对应的key值，全表扫描
        for (int i = 0; i < hashTable.length; i++) {
            for (Node x = hashTable[i]; x != null; x = x.next) {
                if (x.value == value) {
                    return true;
                }
            }
        }
        return false;
    }

    //判断指定的键值对是否存在
    public boolean contains(int key,int value) {
        int index = hash(key);
        for (Node x = hashTable[index]; x != null; x = x.next) {
            if (x.key == key && x.value == value) {
                return true;
            }
        }
        return false;
    }


    //在哈希表中删除指定的键值对(key,value)
    public boolean remove (int key,int value) {
        int index = hash(key);
        //判断头结点是否是待删除结点
        Node head = hashTable[index];
        if (head.key == key && head.value == value) {
            //此时头结点就是待删除的结点
            hashTable[index] = head.next;
            head = head.next = null;
            size--;
            return true;
        }
        //头结点不是待删除的结点
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.key == key && prev.next.value == value) {
                //prev恰好是待删除结点的前驱
                Node cur = prev.next;
                prev.next = cur.next;
                cur = cur.next = null;
                size--;
                return true;
            } else {
                prev = prev.next;
            }
        }
        //当前哈希表中没有这个结点
        throw new NoSuchElementException("no such node! remove error");
    }


    //哈希表的扩容方法，新数组的长度变为原来的一倍
    private void resize() {
        //新数组长度变为原来的一倍
        Node[] newTable = new Node[hashTable.length << 1];
        //进行元素的搬移，将原数组的所有元素搬移到新数组中
        // 此时取模数要变为新数组的长度
        this.M = newTable.length;
        //元素搬移
        for (int i = 0; i < hashTable.length; i++) {
            for (Node x = hashTable[i]; x != null;) {
                //暂存一下下一个结点的地址
                Node next = x.next;
                //将x搬移到新数组的位置
                int index = hash(x.key);
                //新数组头插
                x.next = newTable[index];
                newTable[index] = x;
                //继续搬移原数组的后继结点
                x = next;
            }
        }
        hashTable = newTable;
    }


}
//当前hash表中保存的结点，key = value 的键值对对象
class Node {
    //对key进行hash运算
    int key;

    int value;
    //下一个结点的地址
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}