package seqlist.leetcode;

public class Code622 {
    /**
     * 设计循环队列
     * MyCircularQueue(k): 构造器，设置队列长度为 k 。
     * Front: 从队首获取元素。如果队列为空，返回 -1 。
     * Rear: 获取队尾元素。如果队列为空，返回 -1 。
     * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
     * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
     * isEmpty(): 检查循环队列是否为空。
     * isFull(): 检查循环队列是否已满。
     */
    class MyCircularQueue {

        private int head;

        private int tail;

        private Integer[] data;

        public MyCircularQueue(int k) {
            data = new Integer[k + 1];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            data[tail] = value;
            tail = (tail + 1) % data.length;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % data.length;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return - 1;
            }
            return data[head];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            if (tail == 0) {
                return data[data.length - 1];
            }
            return data[tail - 1];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (tail+1) % data.length == head;
        }
    }
}
