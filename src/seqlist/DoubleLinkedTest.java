package seqlist;

public class DoubleLinkedTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addFist(1);
//        doubleLinkedList.addFist(2);
//        doubleLinkedList.addFist(3);
//        doubleLinkedList.addLast(2);
//        doubleLinkedList.addLast(2);
//        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(0);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        System.out.println(doubleLinkedList);
//        doubleLinkedList.set(2,4);
//        doubleLinkedList.removeIndex(0);
        doubleLinkedList.removeAllValue(2);
        System.out.println(doubleLinkedList);

//        System.out.println(doubleLinkedList.get(0));
//        System.out.println(doubleLinkedList.get(1));
//        System.out.println(doubleLinkedList.get(3));
//        doubleLinkedList.addIndex(1,4);
//        doubleLinkedList.addIndex(1,5);
//        doubleLinkedList.addIndex(1,6);
//        System.out.println(doubleLinkedList);
    }
}
