package bintree.map_set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/22:29
 * @Description:
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> hashset = new HashSet<>();
        System.out.println(hashset.add(1));
        System.out.println(hashset.add(1));
        System.out.println(hashset.add(2));
        System.out.println(hashset.add(3));
        System.out.println(hashset.contains(3));
        System.out.println(hashset.contains(4));
        System.out.println(hashset.remove(2));
        for (int i : hashset) {
            System.out.print(i + " ");
        }
    }
}
