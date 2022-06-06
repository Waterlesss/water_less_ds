package bintree.heap;

import queue.Queue;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/15:27
 * @Description:基于最大堆的优先级队列
 */
public class PriorityQueue implements Queue<Integer> {

    private MaxHeap heap;

    public PriorityQueue() {
        heap = new MaxHeap();
    }

    @Override
    public void offer(Integer val) {
        heap.add(val);
    }
    //所谓的优先级就是最大值
    @Override
    public Integer poll() {
        return heap.extractMax();
    }

    @Override
    public Integer peek() {
        return heap.peekMax();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "heap=" + heap +
                '}';
    }
}

