package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/
public class P51_NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) return ans;
        f(n, 0, new int[n], ans);
        return ans;
    }

    // 当前在 start 行尝试
    // path: [0...i-1] 行上对应放置皇后的情况
    private static void f(int n, int start, int[] path, List<List<String>> ans) {
        // start 能来到n行，说明在 0 ～ n - 1 行上是正确的答案
        if (start == n) {
            collect(path, ans);
            return;
        }
        // 当前在 j 列上尝试
        for (int j = 0; j < n; j++) {
            if (check(path, start, j)) {
                path[start] = j; // start 行 放置一个皇后
                f(n, start + 1, path, ans);
            }
        }
    }

    private static void collect(int[] path, List<List<String>> ans) {
        List<String> res = new ArrayList<>();
        int n = path.length;
        for (int j : path) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(n));
            sb.setCharAt(j, 'Q');
            res.add(sb.toString());
        }
        ans.add(res);
    }

    // 坚持如果来到 i 行，j 列的时候是否符合N皇后，在列上，对角线上都不能放对应的皇后
    private static boolean check(int[] path, int i, int j) {
        // 0～i 行上，对应path已经选择的情况
        for (int k = 0; k < i; k++) {
            if (j == path[k] || (Math.abs(i - k) == Math.abs(j - path[k]))) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        System.out.println(solveNQueens(4));
    }
}
