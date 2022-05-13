package stack.leetcode;

import java.util.Stack;

public class Code232 {
            //双栈实现队列
        class MyQueue {
            //s1永远是保存元素的栈，就对应队列
            private Stack<Integer> s1 = new Stack<>();
            //s2作为辅助，s1弹出压入s2再入s1
            private Stack<Integer> s2 = new Stack<>();
            public MyQueue() {

            }

            public void push(int x) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(x);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }

            public int pop() {
                return s1.pop();
            }

            public int peek() {
                return s1.peek();
            }

            public boolean empty() {
                return s1.isEmpty();
            }
        }
}
