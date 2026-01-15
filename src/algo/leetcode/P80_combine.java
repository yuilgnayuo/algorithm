package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/uUsW3B/
public class P80_combine {
    static void main() {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        f(n + 1, 1, new int[k], 0, ans);
        return ans;
    }

    private static void f(int n, int i, int[] path, int size, List<List<Integer>> ans) {
        if (size == path.length) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                res.add(path[j]);
            }
            ans.add(res);
            return;
        }
        if (i == n) return;
        path[size] = i;
        f(n, i + 1, path, size + 1, ans); // yao
        f(n, i + 1, path, size, ans);
    }
}
