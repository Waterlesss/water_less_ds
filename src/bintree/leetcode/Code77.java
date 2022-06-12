package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Waterless
 * @Date: 2022/06/12/17:47
 * @Description: 给定两个整数 n 和 k，
 * 返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 回溯算法 组合问题
 */
public class Code77 {
    List<Integer> arr = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return list;
        }
        dfs(n, k, 1);
        return list;
    }

    public void dfs(int n, int k, int startIndex) {
        if (arr.size() == k) {
            //arr保存的是同一个地址，必须要new一个对象
            // 不然后面的remove会把这同一个arr删除
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            arr.add(i);
            dfs(n,k,i+1);
            arr.remove(arr.size() -1 );
        }
    }
}
