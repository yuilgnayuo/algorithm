package algo.zuo.code38;


import java.util.ArrayList;
import java.util.List;

// 没有重复项数字的全排列
// 测试链接 : https://leetcode.cn/problems/permutations/
public class Code03_Permutations {

    static void main() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            ans.add(res);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j); // 交换算结果
                f(nums, i + 1, ans);
                swap(nums, i, j); // 恢复现场
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
