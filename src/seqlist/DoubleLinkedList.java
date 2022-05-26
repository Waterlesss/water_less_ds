package seqlist;

public class DoubleLinkedList {
    private int size;
    //当前头结点
    private DoubleNode head;
    //当前尾结点
    private DoubleNode tail;

    public void addFist(int val) {
        DoubleNode node = new DoubleNode(null, val, head);
        if (head == null) {
            tail = node;
        } else {
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void addLast(int val) {
        DoubleNode node = new DoubleNode(tail, val, null);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addIndex(int index, int val) {
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
            DoubleNode node = new DoubleNode(prev, val, prev.next);
            prev.next.prev = node;
            prev.next = node;
            size++;
        }
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index is illegal");
            return;
        }
        DoubleNode cur = findNode(index);
        unlink(cur);
    }

    public void removeValueOnce(int val) {
        for (DoubleNode x = head; x != null; x = x.next) {
            if (x.val == val) {
                unlink(x);
                break;
            }
        }
    }

    public void removeAllValue(int val) {
        for (DoubleNode x = head; x != null;) {
            if (x.val == val) {
                DoubleNode successor = x.next;
                unlink(x);
                x = successor;
            } else {
                x = x.next;
            }
        }
    }

    public void removeFirst() {
        removeIndex(0);
    }

    public void removeLast() {
        removeIndex(size - 1);
    }

    public void unlink(DoubleNode node) {
        DoubleNode prev = node.prev;
        DoubleNode successor = node.next;
        if (prev == null) {
            head = node.next;
        } else {
            prev.next = successor;
            node.prev = null;
        }
        if (successor == null) {
            tail = prev;
        } else {
            successor.prev = prev;
            node.next = null;
        }
        size--;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index is illegal");
            return -1;
        }
        if (index == 0) {
            return head.val;
        }
        DoubleNode prev = findNode(index - 1);
        return prev.next.val;
    }

    public int set(int index, int newVal) {
        if (index < 0 || index >= size) {
            System.out.println("index is illegal");
            return -1;
        }
        if (index == 0) {
            return head.val = newVal;
        }
        DoubleNode prev = findNode(index - 1);
        return prev.next.val = newVal;
    }

    private DoubleNode findNode(int index) {
        DoubleNode x = null;
        if (index < size / 2) {
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    public String toString() {
        String ret = "";
        for (DoubleNode x = head; x != null; x = x.next) {
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
