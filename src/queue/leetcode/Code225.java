package queue.leetcode;


import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class Code225 {
    class MyStack {

        //用双队列实现栈
        public MyStack() {

        }
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            //新元素直接入q2
            q2.offer(x);
            //老元素出q1 入q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
