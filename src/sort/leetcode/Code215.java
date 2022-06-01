package sort.leetcode;

import java.util.Arrays;

/**
 * @Author: Waterless
 * @Date: 2022/06/01/17:26
 * @Description:数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Code215 {
    //解法1 快速排序分区法
    public int findKthLargest(int[] nums, int k) {
        return quickSortInternalHoare(nums, 0, nums.length - 1, k);
    }

    private int quickSortInternalHoare(int[] arr, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        int p = partitionHoare(arr, l, r);
        //继续在左右两个子区间进行快速排序
        //所有 < v的元素
        //所有 >= v 的元素
        if (p == arr.length - k) {
            return arr[p];
        }
        if (p < arr.length - k) {
            return quickSortInternalHoare(arr, p + 1, r, k);
        } else {
            return quickSortInternalHoare(arr, l, p - 1, k);
        }
    }

    private int partitionHoare(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            //先让j从后向前扫描到第一个 < pivot 的元素停止
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            //再让i从前到后扫描到第一个大于pivot的元素停止
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }
    //解法2
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }
}
