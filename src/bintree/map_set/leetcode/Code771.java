package bintree.map_set.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/9:55
 * @Description:
 */
public class Code771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for (int j = 0; j < stones.length(); j++) {
            if (set.contains(stones.charAt(j))) {
                count++;
            }
        }
        return count;
    }
}
