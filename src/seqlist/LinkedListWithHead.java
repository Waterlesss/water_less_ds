package seqlist;

public class LinkedListWithHead {
    private int size;
    private Node unrealHead = new Node();

    public void add(int val) {
        Node node = new Node(val, unrealHead.next);
//        node.next = unrealHead.next;
        unrealHead.next = node;
        size++;
    }

    public void addIndex(int index, int val) {
        if (index < 0 || index > size - 1) {
            System.out.println("index is illegal ");
            return;
        }
        Node prev = unrealHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(val, prev.next);
        prev.next = node;

        size++;
    }

    public int remove(int index) {
        if (index < 0 || index > size - 1) {
            System.out.println("index is illegal ");
            return -1;
        }
        Node prev = unrealHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = prev.next;
        int res = node.val;
        prev.next = node.next;
        node.next = null;
        size --;
        return res;
    }

    public void removeAllValue(int val) {
        Node prev = unrealHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next= prev.next.next;
                size--;
            }else {
                prev = prev.next;
            }
        }
    }

    class Node {
        private int val;
        private Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }


    }
    public String toString() {
        String ret = "";
        for (Node x = unrealHead.next;x != null;x = x.next) {
            ret = ret + x.val;
            ret = ret + "->";
        }
        ret = ret + "null";
        return ret;
    }

}
