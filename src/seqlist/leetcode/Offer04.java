package seqlist.leetcode;

/**
 * @Author: Waterless
 * @Date: 2022/06/04/21:08
 * @Description: 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 */
public class Offer04 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int i = 0;
            int j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                if (target < matrix[i][j]) {
                    j--;
                } else if (target > matrix[i][j]) {
                    i++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
