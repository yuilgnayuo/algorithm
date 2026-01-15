package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/subsets-ii/
public class P90_SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
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
        } else {
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            // 不要当前位置的数据
            f(nums, j, path, size, ans);
            // 要 x 个当前的数据
            for (; i < j; i++) {
                path[size++] = nums[i];
                f(nums, j, path, size, ans);
            }
        }
    }
}
