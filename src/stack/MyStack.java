package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack<E> {
    //记录当前元素个数
    private int size;
    //实际存储数据的动态数组，此时在栈中只能在数组末尾添加和删除元素
    private List<E> data = new ArrayList<>();
    //向当前栈中添加元素
    public void push(E val) {
        //默认在数组的尾部插入
        data.add(val);
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈空，无法出栈");
        }
        //数组末尾删除元素,返回删除前的元素值
         E val = data.remove(size - 1);
        size --;
        return val;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    //查看当前栈顶元素值，不弹出该元素
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈空，无法查看");
        }
        return data.get(size - 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if (i != size-1) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
