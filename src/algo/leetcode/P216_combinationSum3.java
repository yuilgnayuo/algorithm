package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum-iii/
public class P216_combinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        f(1, n, k, path, ans);
        return ans;
    }

    private static void f(int start, int target, int k, List<Integer> path,
                          List<List<Integer>> ans) {
        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (start == 10) return;
        for (int i = start; i < 10; i++) {
            // 剪支
            if (i > target) {
                break;
            }
            path.add(i);
            f(i + 1, target - i, k - 1, path, ans); // 要，i不加1，可以被要多次
            path.removeLast(); // 要完当前数，之后进行移除，恢复现场
        }
    }

    static void main() {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
