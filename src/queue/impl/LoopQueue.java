package queue.impl;

import queue.Queue;

import java.util.NoSuchElementException;

//基于整型的循环队列
public class LoopQueue implements Queue<Integer> {
    //定长数组
    private Integer[] data;
    //队首
    private int head;
    //队尾
    private int tail;

    public LoopQueue(int size) {
        //因为循环队列中要浪费一个空间判断是否已满
        data = new Integer[size + 1];
    }

    @Override
    public void offer(Integer val) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("LoopQueue is full");
        }
        data[tail] = val;
        tail = (tail + 1) % data.length;

    }

    @Override
    public Integer poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("LoopQueue is empty");
        }
        //移动队首元素
        Integer val = data[head];
        head = (head + 1) % data.length;
        return val;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            throw new NoSuchElementException(" LoopQueue is empty");
        }
        return data[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head [");
        //最后一个有效元素的索引
        int lastIndex = tail == 0 ? data.length - 1 : tail - 1;
        for (int i = head; i != tail;) {
            sb.append(data[i]);
           if (i != lastIndex) {
               sb.append(", ");
           }
            i = (i + 1) % data.length;
        }
        sb.append("] tail");
        return sb.toString();
    }
}
