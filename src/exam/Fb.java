package exam;

import java.util.Scanner;

/**
 * @Author: Waterless
 * @Date: 2022/06/12/11:37
 * @Description: 给定一个整数，求出最少需要几步可以将其转变为斐波那契数
 */
public class Fb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fb = scanner.nextInt();
        System.out.println(toFb(fb));
    }
    public static int toFb(int i) {
        int m = 0;
        int n = 1;
        while (n < i) {
            int tmp = n;
            n = m + n;
            m = tmp;
        }
        if (i == m || i == n) {
            return 0;
        } else if (i > m && i < n) {
            return Math.min(i -m,n-i);
        } else {
            return n - i;
        }
    }
}
