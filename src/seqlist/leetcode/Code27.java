package seqlist.leetcode;

import java.util.Arrays;

public class Code27 {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        Code27 Code27 = new Code27();
        Code27.removeElement(nums,3);
        System.out.println(Code27.removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }
    public int removeElement(int[] nums, int val) {
        int firNum = 0;
        int secNUm = 0;
        while(secNUm < nums.length) {
            if (nums[secNUm] != val) {
                nums[firNum] = nums[secNUm];
                firNum++;
            }
                secNUm++;
        }
        return firNum;
    }
}
