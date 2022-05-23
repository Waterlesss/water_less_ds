package com.zy;


public class LinkedList {
    private Node head;
    private int size;

    public void addFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = node;
//            node.next = null;
        }
        size++;
    }

    public void addIndex(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("index is illegal");
            return;
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }
        Node node = new Node(val);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public int removeIndexValue(int index) {
        if (index < 0 || index > size - 1) {
            System.out.println("index is illegal");
            return -1;
        }
        if (index == 0) {
            Node cur = head;
            head = head.next;
            cur.next = null;
            size--;
            return cur.val;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node node = prev.next;
        prev.next = node.next;
        node.next = null;
        size--;
        return node.val;
    }

    public void removeValueOnce(int val) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        if (head.val == val) {
            Node cur = head;
            head = cur.next;
            cur.next = null;
            size--;
            return;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                Node node = prev.next;
                prev.next = node.next;
                node.next = null;
                size--;
                return;
            }
                prev = prev.next;

        }
    }

    public void removeAllValue(int val) {
        while (head != null && head.val == val) {
            Node cur = head;
            head = head.next;
            cur.next = null;
            size--;
        }
        if (head == null) {
            System.out.println("链表为空");
            return;
        } else {
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;

//                    Node node = cur.next;
//                    cur.next = node.next;
//                    node.next = null;
                    size--;
                } else {
                    cur = cur.next;
                }
            }
        }
    }

    public int set(int index,int newVal) {
        if (rangeCheck(index)) {
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            int res = prev.val;
            prev.val = newVal;
            return res;
        }
        return -1;
    }

    public boolean contains(int val) {
//        int index = getByValue(val);
//         if (index != -1) {
//             return true;
//         }
//         return false;

//        return index != -1;

        return getByValue(val) != -1;

//        if(head == null) {
//            return false;
//        }
//        if (head.val == val) {
//            return true;
//        }
//        Node cur = head;
//        while (cur.next != null) {
//            if (cur.next.val == val) {
//                return true;
//            }
//            cur =cur.next;
//        }
//        return false;
    }

    //查询第一个值为val的结点 并返回它的索引
    public int getByValue(int val) {
        int index = 0;
        for (Node x = head;x != null;x = x.next) {
            if (x.val == val) {
                return index;
            }
            index ++;
        }
        return -1;
    }

    public int get(int index) {
        if (rangeCheck(index)) {
            Node cur =head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
        return -1;
    }

    class Node {
        private int val;
        private Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

//        public Node(int val, Node next) {
//this.val =val;
//this.next = null;
//        }
    }

    private boolean rangeCheck(int index) {
            if (index < 0 || index > size -1 ) {
                return false;
            }
            return true;
    }

    public int linkedSize() {
        int count = size;
        return count;
    }

    public String toString() {
        String ret = "";
        Node prev = head;
        while (prev != null) {
            ret = ret + prev.val;
            ret = ret + "->";
            prev = prev.next;
        }
        ret = ret + "null";
        return ret;
    }
}



