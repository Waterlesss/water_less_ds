package seqlist.leetcode;

import java.util.Arrays;

public class Code283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Code283 code283 = new Code283();
        code283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int fir = 0;
        int sec = 0;
        while (sec < nums.length) {
            if (nums[sec] != 0) {
                int tmp = nums[sec];
                nums[sec] = nums[fir];
                nums[fir] = tmp;
                fir++;
                sec++;
            }else {
                sec++;
            }
        }
    }
}
