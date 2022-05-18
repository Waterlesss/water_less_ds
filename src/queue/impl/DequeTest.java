package queue.impl;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        //现在需要的是一个栈
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(1);
//        stack.push(3);
//        stack.push(5);
//        stack.push(7);
//        System.out.println(stack);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
        //现在需要一个队列
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
