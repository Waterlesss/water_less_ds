package queue.impl;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedQueue<>();
//        queue.offer(1);
//        queue.offer(3);
//        queue.offer(5);
//        queue.offer(7);
//        System.out.println(queue);
//        queue.poll();
//        System.out.println(queue);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        System.out.println(queue);

        System.out.println(queue.size());
    }
}
