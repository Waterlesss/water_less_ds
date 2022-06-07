package bintree.map_set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/23:54
 * @Description:
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> treeset = new TreeSet<>();
        treeset.add(1);
        treeset.add(4);
        treeset.add(1);
        treeset.add(5);
        treeset.add(2);
//        System.out.println(treeset.add(1));
//        System.out.println(treeset.add(1));
//        System.out.println(treeset.add(2));
//        System.out.println(treeset.add(3));
        System.out.println(treeset.toString());
    }
}
