package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Waterless
 * @Date: 2022/06/12/19:22
 * @Description: 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Code46 {

    static List<Integer>  arr = new ArrayList<>();
   static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> lists =permute(nums);
        System.out.println(lists);
    }
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return list;
        }
        int[] sign = new int[nums.length];
        dfs(nums,nums.length,sign);
        return list;
    }

    private static void dfs(int[] nums, int length,int[] sign) {
        if (arr.size() == length) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (sign[j] == 0) {
                arr.add(nums[j]);
                sign[j] = 1;
                dfs(nums,length,sign);
                arr.remove(arr.size() - 1);
                sign[j] = 0;
            }
        }
    }
}
