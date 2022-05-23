package seqlist;


import seqlist.LinkedList;

public class LinkedTest {
    public static void main(String[] args) {

       LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(3);
        linkedList.addLast(3);
//        linkedList.addIndex(4,3);
//        linkedList.removeIndexValue(0);
        System.out.println(linkedList);
//        System.out.println(linkedList.contains(1));
//        System.out.println(linkedList.getByValue(3));
//        linkedList.removeAllValue(3);
        linkedList.removeValueOnce(3);
        System.out.println(linkedList);
//        System.out.println(linkedList.linkedSize());
    }
}
