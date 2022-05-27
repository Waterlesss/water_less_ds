package sort;


/**
 * @Author: Waterless
 * @Date: 2022/05/27/10:47
 * @Description:七大排序
 */
public class SevenSort {
    public static void main(String[] args) {
//        int[] arr = {19,27,13,22,3,1,6,5,4,2,100,67,70,98};
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
        int n = 100000;
        int[] arr = SortHelper.generaRandomArray(n,0,Integer.MAX_VALUE);
//        int[] data = SortHelper.generateSortedArray(n,10);
        int[] data = SortHelper.generateSortedArray(n,10);
        int[] arr1 = SortHelper.arrCopy(arr);
        int[] arr2 = SortHelper.arrCopy(arr);
        int[] arr3 = SortHelper.arrCopy(arr);
        SortHelper.testSort(arr,"selectionSort");
//        SortHelper.testSort(arr1,"heapSort");
        SortHelper.testSort(arr1,"selectionSortOP");
//        SortHelper.testSort(arr1,"insertionSort");
//        SortHelper.testSort(arr3,"insertionSortBS");
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
