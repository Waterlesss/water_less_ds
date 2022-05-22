package bintree.heap.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Waterless
 * @Date: 2022/05/22/20:54
 * @Description:
 */
public class Code1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int max1 = queue.poll();
            int max2 = queue.poll();
            if (max1 > max2) {
                queue.offer(max1 - max2);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
