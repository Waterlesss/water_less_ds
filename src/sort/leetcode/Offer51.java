package sort.leetcode;

/**
 * @Author: Waterless
 * @Date: 2022/05/30/11:17
 * @Description:数组中的逆序对 剑指offer51题
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Offer51 {

    /**
     * 在nums[l...r]上进行归并排序，返回排序后的逆序对的个数
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int reversePairs(int[] nums, int l, int r) {
        return reversePairsInternal(nums,0,nums.length - 1);
    }

    private int merge(int[] nums, int l, int mid, int r) {
        //合并时产生的逆序对个数
        int count = 0;
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = nums[i];
        }
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i < mid) {
                //第一个数组已经遍历完了，直接拼接第二个数组，此时没有逆序对
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //第二个数组已经遍历完了，直接拼接第一个数组，此时没有逆序对
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= aux[j - l]) {
                //拼接第一个数组，此时没有逆序
                nums[k] = aux[i - l];
                i++;
            } else {
                //此时第一个数组元素 大于第二个数组元素,arr[i] > arr[j]
                // 从i开始到mid结束的所有元素相较于arr[j]都是逆序对
                //逆序对的个数恰好为mid - i + 1
                count += mid - i + 1;
                nums[k] = aux[j - l];
                j++;
            }
        }
        return count;
    }

    private int reversePairsInternal(int[] nums, int l, int r) {
        //数组为空或只有一个元素
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        //先求出第一个子数组的逆序对个数
        int leftCount = reversePairsInternal(nums, l, mid);
        //再求出第二个子数组的逆序对个数
        int rightCount = reversePairsInternal(nums, mid + 1, r);
        if (nums[mid] > nums[mid + 1]) {
            //左右数组有序后，还存在逆序，merge再求出合并过程中逆序对个数
            return leftCount + rightCount + merge(nums, l, mid, r);
        }
        //nums[mid] < nums[mid + 2],整个数组已经有序，没有逆序对了
        return leftCount + rightCount;
    }
}
