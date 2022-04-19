package seqlist.leetcode;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

public class Code26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Code26 code26 = new Code26();
        System.out.println(code26.removeDuplicates(nums));
        code26.removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int fir = 0;
        int sec = 1;
        while (sec < nums.length) {
            if (nums[sec] != nums[fir]) {
                fir++;
                nums[fir] = nums[sec];
            }
            sec++;
        }
        return fir + 1;
    }

}
