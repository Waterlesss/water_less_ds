package seqlist;


public class SingleLinkedList {
    private Node head;
    private int size;

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addLast(2);
//        singleLinkedList.addLast(2);
//        singleLinkedList.addLast(2);
//        singleLinkedList.addLast(2);

        singleLinkedList.addIndex(1, 3);
        singleLinkedList.addIndex(2, 4);
        singleLinkedList.addIndex(3, 5);
//        System.out.println(singleLinkedList.contains(3));
//        System.out.println(singleLinkedList.getByValue(2));
//        System.out.println(singleLinkedList.get(2));
//        System.out.println(singleLinkedList.rangeCheck(5));
//        System.out.println(singleLinkedList.set(1, 20));
//        System.out.println(singleLinkedList.get(1));
        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.remove(0));
//        singleLinkedList.removeValueOcne(4);
//        singleLinkedList.removeAllValue(2);
//        System.out.println(singleLinkedList);

    }

    public void addFirst(int val) {
        if (head == null) {
            Node node = new Node(val,null);
            head = node;
        } else {
            Node node = new Node(val,head);
            head = node;
        }
        size++;
    }

    public void addLast(int val) {
        addIndex(size, val);
    }
//    public void addLast(int val) {
//        Node node = new Node(val);
//        if (head == null) {
//            addFirst(val);
//            return;
//        }
//        Node cur = head;
//        while (cur.next != null) {
//            cur = cur.next;
//        }
//        cur.next = node;
//        size++;
//    }

    public void addIndex(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("index is illegal");
            return;
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
//        if (index == size) {
//            addLast(val);
//            return;
//        }
//        node.next = searchIndex(index).next;
//        searchIndex(index).next = node;
//        size++;
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node node = new Node(val,cur.next);
        cur.next = node;
        size++;
    }

    //    private Node searchIndex(int index) {
//        if (index < 0 || index > size) {
//            System.out.println("index is illegal");
//        }
//        Node cur = head;
//        for (int i = 0; i < index - 1; i++) {
//            cur = cur.next;
//        }
//        return cur;
//    }

    /*
     * 删除单链表中索引为index位置的结点，返回删除前的结点值
     */
    public int remove(int index) {
        if (rangeCheck(index)) {
            if (index == 0) {
                //删除头节点
                Node cur = head;
                head=head.next;
                cur.next = null;
                size--;
                return cur.val;
            }else {
                //删除其他结点
                Node cur = head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                Node del = cur.next;
                cur.next = del.next;
                del.next = null;
                size--;
                return del.val;
            }
        }
        System.out.println("index is illegal");
        return -1;
    }

    /**
     *删除链表中所有值为val的结点
     */
    public void removeAllValue(int val) {
        while (head != null && head.val == val) {
            Node cur = head;
            head = head.next;
            cur.next = null;
            size--;
        }
        if (head == null) {
            return;
        }else {
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    Node del = cur.next;
                    cur.next = del.next;
                    del.next = null;
                    size--;
                } else {
                    cur = cur.next;
                }
            }
        }
    }

    public int removeFirst() {
         return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除链表中第一个值为val的结点
     */
    public void removeValueOcne(int val) {
        if (head == null) {
            System.out.println("linkedlist is null");
            return;
        }
        if (head.val == val) {
            Node cur = head;
            head = head.next;
            cur.next = null;
            size--;
        }else {
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    Node del = cur.next;
                    cur.next = del.next;
                    del.next = null;
                    size--;
                    return;
                }
                cur = cur.next;
            }
        }
    }

    private boolean rangeCheck(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    /**
     * 修改索引为index位置的节点值为newVal，返回修改前的值
     */
    public int set(int index,int newVal) {
        if (rangeCheck(index)) {
            Node cur =head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            int oldVal = cur.val;
            cur.val = newVal;
            return oldVal;
        }
        return -1;
    }


    /**
     * 查询索引为index位置的节点值
     */
    public int get(int index) {
        if (rangeCheck(index)) {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
        return -1;
    }

    /**
     *查询链表中第一个值为key的结点，并返回它的索引
     */
    public int getByValue(int key) {
        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.val == key) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean contains(int key) {
//        int index = getByValue(key);
//        if (index == -1) {
//            return false;
//        }
//        return true;
        return getByValue(key) != -1;
//        if (head == null) {
//            return false;
//        }
//        Node cur = head;
//        while (cur != null) {
//            if (cur.val == key) {
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;
    }

    public String toString() {
        String ret = "";
        Node x = head;
        while (x != null) {
            ret = ret + x.val;
            ret = ret + "->";
            x = x.next;
        }
        ret = ret + "null";
        return ret;
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
    public Node(int val,Node next) {
        this.val = val;
        this.next = next;
    }
}