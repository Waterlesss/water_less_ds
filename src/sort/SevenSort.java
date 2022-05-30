package sort;


import sun.misc.LRUCache;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Waterless
 * @Date: 2022/05/27/10:47
 * @Description:七大排序
 */
public class SevenSort {
    public static ThreadLocalRandom random = ThreadLocalRandom.current();
    public static void main(String[] args) {
//        int[] arr = {9,5,6,3};
//        mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] arr = {19,27,13,22,3,1,6,5,4,2,100,67,70,98};
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
        int n = 10000000;
        int[] arr = SortHelper.generaRandomArray(n,0,Integer.MAX_VALUE);
        int[] data = SortHelper.generateSortedArray(n,10);
//        int[] data = SortHelper.generateSortedArray(n,10);
        int[] arr1 = SortHelper.arrCopy(arr);
        int[] arr2 = SortHelper.arrCopy(arr);
        int[] arr3 = SortHelper.arrCopy(arr);
////        SortHelper.testSort(arr,"selectionSort");
        SortHelper.testSort(arr,"heapSort");
//        SortHelper.testSort(arr1,"selectionSortOP");
//        SortHelper.testSort(arr1,"insertionSort");
//        SortHelper.testSort(arr3,"shellSort");
        SortHelper.testSort(arr1,"mergeSort");
    }

    //选择排序
    public static void selectionSort(int[] arr) {
        /*无序区间[i...n]
         *有序区间[]
         *最外层循环表示循环的次数，每走一次就有一个最小值放在了正确位置
         */
        for (int i = 0; i < arr.length - 1; i++) {
            //min指的是最小元素的下标
            int min = i;
            //查找当前无序区间最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //j对应的元素，比当前最小值还小，交换索引
                    min = j;
                }
            }
            //此时min对应的元素一定是无序区间的最小值
            //有序区间[0...i] + 1
            //无序区间[0...i] - 1
            swap(arr,i,min);
        }
    }

    //双向选择排序
    public static void selectionSortOP(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        //low == high 无序区间只剩下最后一个元素
        while (low < high) {
            int min = low;
            int max = low;
            for (int i = low + 1; i <= high; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            //此时min对应了最小值 索引，交换到无序区间的最前面
            swap(arr,min,low);
            //边界 low == max
            if (max == low) {
                max = min;
            }
            swap(arr,max,high);
            low++;
            high--;
        }
    }

    /**
     * 直接插入排序
     * 已排序区间[0...i) 默认第一个元素就是已经排好序的区间
     * 待排序区间[i...n)
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //已排序区间[0...1)
            //待排序区间[i...n)
            //选择无序区间的第一个元素，不断向前看
            //内层循环的终止条件是>=1是因为 j-1要合法
            for (int j = i; j >= 1 && arr[j] < arr[j-1]; j--) {
                swap(arr,j,j-1);
                //边界
//                if (arr[j] > arr[j - 1]) {
//                    //当前无序区间的第一个元素 > 有序区间的最后一个元素
//                    //arr[i]恰好是有序区间的最后一个元素，无序区间的第一个元素
//                    break;
//                } else {
//                    swap(arr,j,j-1);
//                }
            }
        }
    }

    /**
     * 二分插入排序
     * @param arr
     */
    public static void insertionSortBS(int[] arr) {
        //有序区间从[0...i)
        //无序区间[i..n)
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            //有序区间[left..right)
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = (left + right) >> 1;
                //无序区间的第一个元素小于有序区间中间位置的元素
                if (val < arr[mid]) {
                    right = mid ;
                } else {
                    left = mid + 1;
                }
            }
            //搬移从left到i的元素
            for (int j = i; j > left ; j--) {
                arr[j] = arr[j-1];
            }
            //left就是待插入的位置
            arr[left] = val;
        }
    }

    /**
     * 希尔排序，缩小增量排序，按照gap将原数组分为gap个子数组，子数组内部先排序
     * 不断缩小gap的值 直到gap=1；此时整个数组近乎有序，再来一次插入排序
     * @param arr
     */
     public static void shellSort(int[] arr) {
        int gap = arr.length >> 1;
        //预处理阶段
         while (gap >= 1) {
             insertionSortByGap(arr,gap);
             gap = gap >> 1;
         }
         //此时gap=1；整个数组近乎有序，再来一次插入排序
     }

    /**
     * 极端情况，假设gap=1; 此时就是个插入排序
     * @param arr
     * @param gap
     */
    private static void insertionSortByGap(int[] arr, int gap) {
        for (int i = gap; i  < arr.length; i++) {
            //j = j - gap 只看相同分组每次走gap步
            for (int j = i; j - gap >= 0 && arr[j] < arr[j - gap] ; j = j - gap) {
                swap(arr,j,j-gap);
            }
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSortInternal(arr,0,arr.length - 1);
    }

    /**
     * 迭代实现归并排序
     * @param arr
     */
    public static void meergeSortNoRecursion(int[] arr) {
        /*
         最外循环表示每次合并的子数组的元素个数
         子数组为1个元素，第二次循环2个元素，第三次循环合并4个元素，以此类推
         直到整个数组合并完成
         */
        for (int size = 1; size <= arr.length ; size = size + size) {
            //内层循环表示merge的操作
            //变量i就是每次合并操作的开始索引l
            for (int i = 0; i + size < arr.length; i = i + size + size) {
                //边界i + size + size - 1 > arr.length
                merge(arr,i,i + size - 1,Math.min(i + size + size - 1,arr.length - 1));
            }
        }
    }

    /**
     *在arr[l...r]上进行归并排序
     * @param arr
     * @param l
     * @param r
     */
    private static void mergeSortInternal(int[] arr, int l, int r) {
        //优化2：小数组直接使用插入排序
        if (r - l <= 15) {
            insertionSort(arr,l,r);
            return;
        }
        //int mid = (l + r) / 2;
        int mid = l + ((r - l) >> 1);
        mergeSortInternal(arr,l,mid);
        mergeSortInternal(arr,mid + 1,r);
        //arr[l...mid] 和 arr[mid + 1...r]已经有序，只需要合并这两个子数组
        //优化1：arr[mid](数组1的最大值) < arr[mid + 1](数组2的最小值) 说明此时整个数组已经有序
        if (arr[mid] > arr[mid + 1]) {
            merge(arr,l,mid,r);
        }
    }

    /**
     * 在arr[l...r]上进行插入排序
     * @param arr
     * @param l
     * @param r
     */
    private static void insertionSort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r ; i++) {
            for (int j = i; j - l >= 1 && arr[j] < arr[j - 1] ; j--) {
                swap(arr,j,j - 1);
            }
        }
    }

    /**
     * 将有序子数组arr[l...mid] 和 arr[mid + 1...r]合并成为一个大的有序数组arr
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        //现创建一个新的数组aux，将子数组的值复制给新数组
        int[] aux = new int[r - l + 1];
        // l = 2,r = 4;
        // arr[2...4];
        // aux[0...2];索引下标差了l个偏移量
        for (int i = 0; i < aux.length; i++) {
            //aux的下标0...arr.length - 1;
            //arr的下标l...r ;
            aux[i] = arr[i + l];
        }
        //数组1的开始下标
        int i = l;
        //数组2的开始下标
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                //第一个数组已经遍历完毕
                arr[k] = aux[j -l];
                j++;
            } else if (j > r) {
                //第二个子数组遍历完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= aux[j - l]) {
                //将aux[i-l]写回arr[k]
                arr[k] = aux[i - l];
                i++;
            } else {
                //aux[i - l] > aux[j - l],写回aux[j - l]
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    //快速排序
    public static void quickSort(int[] arr) {
        quickSortInternal(arr,0,arr.length - 1);
    }

    private static void quickSortInternal(int[] arr, int l, int r) {
        if (r - l <= 15) {
            insertionSort(arr,l,r);
            return;
        }
        int p = partition(arr,l,r);
        //继续在左右两个子区间进行快速排序
        //所有 < v的元素
        quickSortInternal(arr,l,p - 1);
        //所有 >= v 的元素
        quickSortInternal(arr,p + 1,r);
    }

    private static int partition(int[] arr, int l, int r) {
        int randomIndex = random.nextInt(l,r);
        swap(arr,l,randomIndex);
        int v = arr[l];
        //arr[l + 1 ...j] < v
        //最开始区间没有元素,区间的定义就是变量的初始化条件
        int j = l;
        //arr[j + 1...i) >= v
        //最开始大于区间也没有元素
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr,i,j + 1);
                j++;
            }
        }
        //此时元素j就是最后一个小于v的元素，就把v换到j的位置
        swap(arr,l,j);
        return j;
    }


    //原地堆排序
    public static void heapSort(int[] arr) {
        //1.先将任意数组进行heapfiy调整为最大堆
        //从最后一个非叶子节点开始siftDown
        for (int i = (arr.length - 1 - 1) >> 1; i >= 0; i--) {
            siftDown(arr,i,arr.length);
        }
        //2.不断交换堆顶元素到数组末尾，每交换一个元素，就有一个元素落在了最后位置
        for (int j = arr.length - 1; j > 0 ; j--) {
            //arr[j]就是未排序数组的末尾元素，和堆顶元素进行交换
            //此时的堆顶元素就是当前堆的最大值
            swap(arr,0, j);
            //每次交换完后，数组末尾的元素都在堆顶，从堆顶开始siftDown
            siftDown(arr,0, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //i是下沉的索引，length是数组的长度
    private static void siftDown(int[] arr, int i, int length) {
        while ((i << 1) + 1 <length) {
            int index = (i << 1) + 1;
            if (index + 1 < length && arr[index + 1] > arr[index]) {
                index = index + 1;
            }
            if (arr[index] > arr[i]) {
                swap(arr,i,index);
                i = index;
            } else {
                break;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
             boolean isSwaped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    isSwaped = true;
                }
            }
            if (!isSwaped) {
                //内层没有元素交换，此时整个数组已经有序
                break;
            }
        }
    }
}
