package algo.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
// https://leetcode.cn/problems/4sjJUc/description/
public class P82_combinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates, 0, target, path, ans);
        return ans;
    }

    private static void f(int[] candidates, int start, int target, List<Integer> path,
                          List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (start == candidates.length) return;
        for (int i = start; i < candidates.length; i++) {
            // 剪支
            if (candidates[i] > target) {
                break;
            }
            // 去重关键：跳过同一层中相同的元素
            // 解释：i > start 表示不是第一次访问这个数字
            // candidates[i] == candidates[i-1] 表示当前数字和前一个数字相同
            // 在排序数组中，这样就能保证同一层不会使用相同的数字
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            f(candidates, i + 1, target - candidates[i], path, ans); // 要，i不加1，可以被要多次
            path.removeLast(); // 要完当前数，之后进行移除，恢复现场
        }
    }

    static void main() {
        int[] num = {2, 5, 2, 1, 2};
        System.out.println(combinationSum2(num, 5));
    }
}
