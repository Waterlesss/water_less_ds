package bintree.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 基于动态数组实现的最大堆
 */

public class MaxHeap {

    //实际存储元素的数组
    private List<Integer> elementData;
    //当前堆中元素个数
    private int size;


    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int size) {
        elementData = new ArrayList<>(size);
    }

    //堆化 heapify，将一个任意的整型数组转为最大堆
    public MaxHeap(int[] arr) {
        elementData = new ArrayList<>(arr.length);
        //将arr所有元素复制
        for (int i : arr) {
            elementData.add(i);
            size++;
        }
        //从最后一个非叶子结点开始进行siftdown操作
        for (int i = parent(size - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }


    public void add(int val) {
        //直接在数组末尾添加元素
        elementData.add(val);
        size++;
        //进行元素的上浮操作
        siftUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        //树根就是最大值结点
        int max = elementData.get(0);
        //将数组末尾元素覆盖到堆顶
        elementData.set(0,elementData.get(size - 1));
        //将数组的最后一个元素从堆中删除
        elementData.remove(size - 1);
        size--;
        //元素下沉，从堆顶开始
        siftDown(0);
        return max;
    }

    //从索引k开始进行元素的下沉操作
    private void siftDown(int k) {
        while (leftChild(k) < size) {
            int i = leftChild(k);
            if (i + 1 < size && elementData.get(i + 1) > elementData.get(i)) {
                i++;
            }
            if (elementData.get(k) < elementData.get(i)) {
                swap(k,i);
                k = i;
            } else {
                break;
            }
        }
    }


    private void siftUp(int k) {
        while (k > 0 && elementData.get(k) > elementData.get(parent(k))) {
            swap(k , parent(k));
            k = parent(k);
        }
    }


    private void swap(int k, int parent) {
        int child = elementData.get(k);
        int parentVal = elementData.get(parent);
        elementData.set(parent,child);
        elementData.set(k,parentVal);
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peekMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        return elementData.get(0);
    }


    //找到结点k对应的父节点索引
    private int parent(int k) {
        //右移一位代表÷2
        return (k - 1) >> 1;
    }
    //找到结点k对应的左子树的索引
    private int leftChild(int k) {
        //左移一位代表×2
        return (k << 1) + 1;
    }
    //找到结点k对应的右子树的索引
    private int rightChild(int k) {
        return (k << 1) + 2;
    }

    @Override
    public String toString() {
        return elementData.toString();
    }
}
