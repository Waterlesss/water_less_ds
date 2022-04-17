package seqlist;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Arrays;

public class MyArray {
    private int[] data;
    //当前动态数组已经存储元素的个数
    private int size;

    //    public MyArray () {
//        //默认开辟10个大小的整型数组长度
//        this(10);
//    }
    public MyArray(int initCap) {
        this.data = new int[initCap];
    }

    //在当前数组中添加一个新元素val
    public void add(int val) {
        data[size] = val;
        size++;
        //判断数组是否已满，并进行扩容
        if (size == data.length) {
            grow();
        }
    }

    public void add(int index, int val) {
        /**
         * 先判断边界条件，index是不是一个非法索引
         * size是有效元素的个数
         */
        if (index < 0 || index > size) {
            System.err.println("index is illegal");
        }
        //从当前最后一个有效元素开始向后搬移，把index位置空出来
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //index位置空出来了，此时可以插入val;
        data[index] = val;
        size++;
        if (size == data.length) {
            grow();
        }
    }

    //查询当前动态数组中第一个值为val的元素的索引，若不存在  返回-1
    public int getByValue(int val) {
        for (int i = 0; i < size; i++) {
            if (data[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //查询当前动态数组中是否存在值为val的元素
    public boolean contains(int val) {
        if (getByValue(val) != -1) {
            return true;
        }
        return false;
    }

    //查询当前动态数组中索引为index的元素值
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.err.println("index is illegal");
            return -1;
        }
        return data[index];
    }

    //修改index位置的元素为newVal，并返回之前的元素oldVal
    public int set(int index, int newVal) {
        if (index < 0 || index >= size) {
            return -1;
        }
        int oldVal = data[index];
        data[index] = newVal;
        return oldVal;
    }

    //将动态数组中第一个值为oldVal的元素修改为newVal
    public boolean setValue(int oldVal, int newVal) {
        int index = getByValue(oldVal);
        if (index != -1) {
            data[index] = newVal;
            return true;
        }
        System.out.println("oldVal is not exist!");
        return false;
    }

    //删除索引为index对应的元素值，返回删除前的元素值
    public int removeIndex(int index) {
        if (index < 0 || index >= size) {
            System.err.println("remove index is illegal");
            return -1;
        }
        //元素搬移，从index开始，后一个元素覆盖前一个元素
        // 一直走到size-1（最后一个有效元素）
        //
        int oldVal = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return oldVal;
    }

    public int removeFirst() {
        return removeIndex(0);
    }

    public int removeLast() {
        return removeIndex(size - 1);
    }
//只删除第一个值为val的元素
    public boolean removeByValueOnce(int val) {
        for (int i = 0; i < size; i++) {
            if (data[i] == val) {
                removeIndex(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAllValue(int val) {
        if (getByValue(val) == -1) {
            return false;
        }
        for (int j = 0; j < size; j++) {
                if (data[j] == val) {
                    removeIndex(j);
                    j--;
                }
            }
            return true;
//        if (getByValue(val) != -1) {
//            for (int j = 0; j < size; j++) {
//                if (data[j] == val) {
//                    removeIndex(j);
//                    j--;
//                }
//            }
//            return true;
//        }
//        return false;
    }
    public String toString() {
        String ret = "[";
        //此时取得是有效数据，所以小于size
        for (int i = 0; i < size; i++) {
            ret = ret + data[i];
            if (i != size - 1) {
                ret = ret + ",";
            }
        }
        ret = ret + "]";
        return ret;
    }

    private void grow() {
        this.data = Arrays.copyOf(data, data.length * 2);
    }
}
