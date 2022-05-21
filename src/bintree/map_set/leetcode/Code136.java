package bintree.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waterless
 * @Date: 2022/05/20/14:52
 * @Description:给定一个非空整数数组，
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Code136 {
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
