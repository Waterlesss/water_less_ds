package bintree.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/9:17
 * @Description:
 */
public class Code290 {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }
        int count = 1;
        StringBuilder sb1 = new StringBuilder();
        Map<String,Integer> map1 = new HashMap<>();
        for (String i : str) {
            if (!map1.containsKey(i)) {
                map1.put(i,count);
                sb1.append(count ++);
            } else {
                sb1.append(map1.get(i));
            }
        }
        count = 1;
        StringBuilder sb2 = new StringBuilder();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int j = 0; j < pattern.length(); j++) {
            char c = pattern.charAt(j);
            if (!map2.containsKey(c)) {
                map2.put(c,count);
                sb2.append(count ++);
            } else {
                sb2.append(map2.get(c));
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
