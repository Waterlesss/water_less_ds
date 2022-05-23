package seqlist;

public class LinkedWithHeadTest {
    public static void main(String[] args) {
        LinkedListWithHead linkedListWithHead =new LinkedListWithHead();
        linkedListWithHead.add(3);
        linkedListWithHead.add(1);
        linkedListWithHead.add(2);
        linkedListWithHead.add(2);
        linkedListWithHead.add(3);
        linkedListWithHead.addIndex(0,3);
        System.out.println(linkedListWithHead);
//        linkedListWithHead.remove(0);
//        System.out.println(linkedListWithHead.remove(0));
        linkedListWithHead.removeAllValue(3);
        System.out.println(linkedListWithHead);

    }
}
