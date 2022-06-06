package bintree.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/15:36
 * @Description:
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] data = new int[] {3,5,7,6,2,1,9,4};
//        Queue<Integer> queue = new PriorityQueue();
        //JDK默认的最小堆
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : data) {
            queue.offer(i);
        }
        System.out.println(queue);
    }
}
