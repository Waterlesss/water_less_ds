package seqlist;

public class DoubleLinkedList {
    private  int size;
    //当前头结点
    private DoubleNode head;
    //当前尾结点
    private DoubleNode tail;

    public void addFist(int val) {
        DoubleNode node = new DoubleNode(null,val,head);
        if (head == null) {
           tail = node;
        } else {
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void addLast(int val) {
        DoubleNode node = new DoubleNode(tail,val,null);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addIndex(int index,int val) {
        if (index < 0 || index > size) {
            System.out.println("index is illegal");
            return;
        }
        if (index == 0) {
            addFist(val);
        } else if (index == size) {
            addLast(val);
        } else {
            DoubleNode prev = findNode(index - 1);
            DoubleNode node = new DoubleNode(prev,val,prev.next);
            prev.next.prev = node;
            prev.next = node;
            size++;
        }
    }

    private DoubleNode findNode(int index) {
        if (index < size / 2) {
            DoubleNode x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return  x;
        } else {
            DoubleNode x = tail;
            for (int i =size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public String toString() {
        String ret = "";
        for(DoubleNode x = head; x != null;x = x.next) {
            ret = ret + x.val;
            ret = ret + "->";
        }
        ret = ret + "null";
        return ret;
    }

}

//双向链表的结点类
class DoubleNode {
    //前驱
    DoubleNode prev;
    int val;
    //后继
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int val) {
        this.val = val;
    }

    public DoubleNode(DoubleNode prev, int val, DoubleNode next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}
