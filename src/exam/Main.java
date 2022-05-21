package exam;

import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println();
        printStr(str);
    }

    private static void printStr(String str) {
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char str1 = str.charAt(i);
            if (i == str.indexOf(str1)) {
                sb.append(str1);
            }
        }
        System.out.println(sb);
    }
}
