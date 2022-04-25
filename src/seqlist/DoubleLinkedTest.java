package seqlist;

public class DoubleLinkedTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addFist(1);
//        doubleLinkedList.addFist(2);
//        doubleLinkedList.addFist(3);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        System.out.println(doubleLinkedList);
        doubleLinkedList.addIndex(1,4);
        doubleLinkedList.addIndex(1,5);
        doubleLinkedList.addIndex(1,6);
        System.out.println(doubleLinkedList);
    }
}
