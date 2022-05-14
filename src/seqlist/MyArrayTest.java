package seqlist;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(3);
        myArray.add(10);
        myArray.add(20);
        myArray.add(20);
        myArray.add(20);
        myArray.add(30);
        myArray.add(30);
        myArray.add(20);
//        myArray.add(1,12);
//        myArray.add(0,9);
//        myArray.add(6,41);
//        System.out.println(myArray.set(1,11));
//        System.out.println(myArray.setValue(20,21));
//        System.out.println(myArray.getByValue(30));
//        System.out.println(myArray.contains(100));
//        System.out.println(myArray.contains(20));
//        System.out.println(myArray.get(2));
        System.out.println(myArray);
//        System.out.println(myArray.removeIndex(1));
//        System.out.println(myArray.removeFirst());
//        System.out.println(myArray.removeLast());
//        System.out.println(myArray.removeByValueOnce(20));
        System.out.println(myArray.removeAllValue(20));
//        System.out.println(myArray.removeAllValue(30));
        System.out.println(myArray);
    }

}
