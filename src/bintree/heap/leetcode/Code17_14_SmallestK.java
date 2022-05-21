package bintree.heap.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/16:06
 * @Description:最小的k个数
 */

//class IntReverse implements Comparator<Integer> {
//
//
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return o2 - o1;
//    }
//}

public class Code17_14_SmallestK {
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr.length == 0) {
            return ret;
        }
        //JDK默认是一个最小堆，改造成最大堆
        //匿名内部类
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else {
                int max = queue.peek();
                if (arr[i] < max) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        //此时队列中就保存了前k个最小值元素
        int i = 0;
        while (!queue.isEmpty()) {
            ret[i] = queue.poll();
            i++;
        }
        return ret;
//        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
    }
}
