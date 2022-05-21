package bintree.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/10:42
 * @Description:给你一个整数数组 nums ，
 * 除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class Code137 {
    public int singleNumber(int[] nums) {
        //1.先扫描原数组，将每个元素以及出现的频次保存到Map中
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        //2.遍历map，找到频次只有1的元素
        int ret = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                ret =entry.getKey();
            }
        }
        return ret;
    }
}
