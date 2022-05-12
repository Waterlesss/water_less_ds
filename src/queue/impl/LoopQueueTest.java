package queue.impl;

import queue.Queue;

public class LoopQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue(4);
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        System.out.println(queue);
//        queue.offer(9);
        queue.poll();
        queue.poll();
        System.out.println(queue);
        queue.poll();
        queue.poll();
        System.out.println(queue);
        queue.poll();
    }

}
