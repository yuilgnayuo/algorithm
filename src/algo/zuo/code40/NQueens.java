package algo.zuo.code40;


// N皇后问题
// 测试链接 : https://leetcode.cn/problems/n-queens-ii/
public class NQueens {

    //
    public static int totalNQueens1(int n) {
        if (n < 1) return 0;
        return f(n, 0, new int[n]);
    }

    // 当前在 start 行尝试
    // path: [0...i-1] 行上对应放置皇后的情况
    private static int f(int n, int start, int[] path) {
        // start 能来到n行，说明在 0 ～ n-1 行上是正确的答案
        if (start == n) {
            return 1;
        }
        int ans = 0;
        // 当前在j列上尝试
        for (int j = 0; j < n; j++) {
            if (check(path, start, j)) {
                path[start] = j; // start 行 放置一个皇后
                ans += f(n, start + 1, path);
            }
        }
        return ans;
    }

    // 坚持如果来到 i 行，j 列的时候是否符合N皇后，在列上，对角线上都不能放对应的皇后
    private static boolean check(int[] path, int i, int j) {
        for (int k = 0; k < i; k++) {
            if(j == path[k])
        }
        return false;
    }
}
