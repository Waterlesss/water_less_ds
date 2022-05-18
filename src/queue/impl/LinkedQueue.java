package queue.impl;

import queue.Queue;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private int size;

    private Node<E> head;

    private Node<E> tail;

    @Override
    public void offer(E val) {
        //产生一个新节点
        Node<E> node = new Node<>(val);
        if (head == null) {
            head = tail = node;
        } else {
            //链表的尾插
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * dda dsd
     * @return
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty!");
        }
        //删除当前队首元素
        E val = head.val;
        Node<E> node = head;
        head = head.next;
        node.next = node = null;
        size--;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return head.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public  String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head [");
        for (Node<E> x = head; x != null;x = x.next) {
            sb.append(x.val);
            if (x.next != null) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
class Node<E> {
    E val;
    Node<E> next;

    public Node(E val) {
        this.val = val;
    }
}
