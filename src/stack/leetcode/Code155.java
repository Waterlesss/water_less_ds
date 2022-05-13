package stack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 双栈实现最小栈
 * 整个操作的核心在于s2为空，直接入栈
 * 当s2的栈顶元素 > 当前元素，直接入栈
 * 当s2的栈顶元素 < 当前元素就把栈顶元素再入一遍栈
 * s2的元素个数和s1保持一致
 */
public class Code155 {
    class MinStack {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        public MinStack() {

        }

        public void push(int val) {
            s1.push(val);
            if (s2.isEmpty()) {
                s2.push(val);
            } else {
                int peek = s2.peek();
                s2.push(Math.min(val,s2.peek()));
//                if (val > s2.peek()) {
//                    s2.push(s2.peek());
//                } else {
//                    s2.push(val);
//                }
            }
        }

        public void pop() {
            s1.pop();
            s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }
    }
}
