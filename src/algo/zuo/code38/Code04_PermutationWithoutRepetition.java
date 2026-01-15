package algo.zuo.code38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 有重复项数组的去重全排列
// 测试链接 : https://leetcode.cn/problems/permutations-ii/
public class Code04_PermutationWithoutRepetition {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, List<List<Integer>> ans) {
        if (nums.length == i) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            ans.add(res);
        } else {
            HashSet<Integer> set = new HashSet<>();
            // 只有num【j】位置，没有被尝试过，才继续
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    swap(nums, i, j);
                    f(nums, i + 1, ans);
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
