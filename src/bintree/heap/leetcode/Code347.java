package bintree.heap.leetcode;

import java.util.*;

/**
 * @Author: Waterless
 * @Date: 2022/05/19/14:35
 * @Description:给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 */
public class Code347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Code347 code347 = new Code347();
        System.out.println(Arrays.toString(code347.topKFrequent(nums, k)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i,hashMap.getOrDefault(i,0) + 1);
        }
        Queue<Sup> prique = new PriorityQueue<>(new Comparator<Sup>() {
            @Override
            public int compare(Sup o1, Sup o2) {
                return o1.value - o2.value;
            }
        });
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (prique.size() < k) {
                prique.offer(new Sup(entry.getKey(),entry.getValue()));
            } else {
                if (entry.getValue() > prique.peek().value) {
                    prique.poll();
                    prique.offer(new Sup(entry.getKey(),entry.getValue()));
                }
            }
        }
        int[] ret = new int[k];
        int i = 0;
        while (!prique.isEmpty()) {
            ret[i++] = prique.poll().key;
        }
        return ret;
    }
}

class Sup {
    //出现的元素
    Integer key;
    //元素出现的次数
    Integer value;

    public Sup(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

}