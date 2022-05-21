package bintree.map_set.leetcode;

import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/10:23
 * @Description:
 */
public class BadKey {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String expectStr = null;
        String actualStr = null;
        while (sc.hasNextLine()) {
             expectStr = sc.nextLine();
             actualStr = sc.nextLine();
        }
        expectStr = expectStr.toUpperCase();
        actualStr = actualStr.toUpperCase();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < actualStr.length(); i++) {
            set.add(actualStr.charAt(i));
        }
        Set<Character> single = new HashSet<>();
        for (int j = 0; j < expectStr.length(); j++) {
            char c = expectStr.charAt(j);
            if (!set.contains(c)) {
                if (single.add(c)) {
                    System.out.print(c);
                }
            }
        }
    }
}
