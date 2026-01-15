package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/Ygoe9J/description/
public class P81_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        f(candidates, 0, target, combine, ans);
        return ans;
    }

    private void f(int[] candidates, int i, int target, List<Integer> combine, List<List<Integer>> ans) {
        if (i == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        f(candidates, i + 1, target, combine, ans); // 不要，直接跳过
        if (target - candidates[i] >= 0) { // 要当前数
            combine.add(candidates[i]);
            f(candidates, i, target - candidates[i], combine, ans); // 要，i不加1，可以被要多次
            combine.removeLast(); // 要完当前数，之后进行移除，恢复现场
        }
    }
}
