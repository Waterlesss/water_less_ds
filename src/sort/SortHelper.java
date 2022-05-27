package sort;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Waterless
 * @Date: 2022/05/27/10:23
 * @Description:
 */
public class SortHelper {
    //生成随机数的一个类
    private static  final ThreadLocalRandom random = ThreadLocalRandom.current();
    /**
     *1.产生一个大小为n的随机整数数组，数组的取值范围为[l ..r]
     * @param n 是数组的元素个数
     * @param left 是数组取值的最小值
     * @param right 是数组元素的最大值
     * @return
     */
    public static int[]  generaRandomArray(int n, int left, int right) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            //random生成一个[l...r)的随机数
            data[i] = random.nextInt(left,right);
        }
        return data;
    }



    //生成一个大小为n的近乎有序的数组
    //swapTimes是交换的次数，次数越大，数组越无序
    public static int[] generateSortedArray(int n, int swapTimes) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            //生成一个0到n之间的随机数
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
        return data;
    }
    //深拷贝原数组
    public static int[] arrCopy(int[] arr) {
        return Arrays.copyOf(arr,arr.length);
    }

    /**
     * 在指定的数组arr上测试名称为Sort Name的排序算法性能
     * @param arr
     * @param sortName
     */
    public static void testSort(int[] arr, String sortName) {
        Class<SevenSort> cls = SevenSort.class;
        try {
            //拿到相应的算法名称
            Method method = cls.getDeclaredMethod(sortName,int[].class);
            long start = System.nanoTime();
            method.invoke(null,arr);
            long end = System.nanoTime();
            if (isSorted(arr)) {
                System.out.println(sortName + "排序完成，共耗时：" + (end - start) / 1000000.0 + "ms");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //检查当前的数组arr是否是一个非降序数组
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.err.println("排序算法有误!");
                return false;
            }
        }
        return true;
    }
}
