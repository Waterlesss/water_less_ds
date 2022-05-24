package sort;


import java.util.Arrays;

/**
 * @Author: Waterless
 * @Date: 2022/05/20/8:38
 * @Description:七大排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {19,27,13,22,3,1,6,5,4,2,100,67,70,98};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
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
}
