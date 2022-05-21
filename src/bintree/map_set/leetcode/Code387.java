package bintree.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/21:14
 * @Description:给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。
 * 如果不存在，则返回 -1 。
 */
public class Code387 {

    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,count++);
        }
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.get(c).equals(1)) {
                return j;
            }
        }
        return -1;
    }

}
