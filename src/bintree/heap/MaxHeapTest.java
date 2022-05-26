package bintree.heap;

/**
 * @Author: Waterless
 * @Date: 2022/05/17/22:56
 * @Description:
 */
public class MaxHeapTest {
    public static void main(String[] args) {
//        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.add(62);
//        maxHeap.add(41);
//        maxHeap.add(30);
//        maxHeap.add(28);
//        maxHeap.add(16);
//        maxHeap.add(22);
//        maxHeap.add(13);
//        maxHeap.add(19);
//        maxHeap.add(17);
//        maxHeap.add(15);
//        maxHeap.add(52);
//        System.out.println(maxHeap.extractMax());
//        System.out.println(maxHeap);
//        while (!maxHeap.isEmpty()) {
//            System.out.print(maxHeap.extractMax() + " ");
//        }
        int[] data = new int[] {15,17,19,13,22,16,28,30,41,62};
        MaxHeap maxHeap = new MaxHeap(data);
        System.out.println(maxHeap);
    }
}
