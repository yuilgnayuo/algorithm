package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/
public class P78_Subsets {
    static void main() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                res.add(path[j]);
            }
            ans.add(res);
            return;
        }
        path[size] = nums[i];
        f(nums, i + 1, path, size + 1, ans);    // 要当前数据
        f(nums, i + 1, path, size, ans);            // 不要当前数
    }
}
