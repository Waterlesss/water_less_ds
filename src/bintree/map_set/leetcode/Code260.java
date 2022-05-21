package bintree.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/10:47
 * @Description:给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */
public class Code260 {
    public int[] singleNumber(int[] nums) {
        //1.先扫描原数组，将每个元素以及出现的频次保存到Map中
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        //2.遍历map，找到频次只有1的元素
        int[] ret = new int[2];
        int i = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                ret[i++] =entry.getKey();
            }
        }
        return ret;
    }
}
