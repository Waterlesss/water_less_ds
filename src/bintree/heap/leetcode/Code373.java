package bintree.heap.leetcode;

import java.util.*;

/**
 * @Author: Waterless
 * @Date: 2022/05/20/13:54
 * @Description:给定两个以升序排列的整数数组nums1和nums2,以及一个整数k。
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 * 请找到和最小的 k个数对
 */
public class Code373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //创建优先级队列，其中队列中保存Pair对象，传入比较器，和越大反而越小
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o2.u + o2.v) - (o1.u + o1.v);
            }
        });
        //遍历两个数组，其中u来自第一个数组，v来自第二个数组
        for (int i = 0; i < Math.min(nums1.length,k); i++) {
            for (int j = 0; j < Math.min(nums2.length,k); j++) {
                if (queue.size() < k) {
                    queue.offer(new Pair(nums1[i],nums2[j]));
                } else {
                    int sum = nums1[i] + nums2[j];
                    Pair pair = queue.peek();
                    if (sum < (pair.u + pair.v)) {
                        queue.poll();
                        queue.offer(new Pair(nums1[i],nums2[j]));
                    }
                }
            }
        }
        //3.此时队列中保存了和最小的前k个Pair对象，取出其中的u和v即可
        List<List<Integer>> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Pair pair = queue.poll();
            temp.add(pair.u);
            temp.add(pair.v);
            arr.add(temp);
        }
        return arr;
    }
}

class Pair {
    //u来自数组1
    int u;
    //v来自数组2
    int v;

    public Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}