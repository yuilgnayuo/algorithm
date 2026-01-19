package algo.zuo.code40;


// N皇后问题
// 测试链接 : https://leetcode.cn/problems/n-queens-ii/
public class NQueens {

    // 使用数组表示路径的经典实现
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
        // 当前在 j 列上尝试
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
        // 0～i 行上，对应path已经选择的情况
        for (int k = 0; k < i; k++) {
            if (j == path[k] || (Math.abs(i - k) == Math.abs(j - path[k]))) {
                return false;
            }
        }
        return true;
    }


    // 位运算版本，大量优化常数时间
    public static int totalNQueens2(int n) {
        if (n < 1) return 0;
        // 将所有0～n-1位上设置为1
        int limit = (1 << n) - 1;
        return f2(limit, 0, 0, 0);
    }

    // 分别代表：左边，右边，以及当前col上不能放置皇后了
    private static int f2(int limit, int left, int right, int col) {
        // 所有位上皇后都放了，所以这是一种有效的解
        if (col == limit) return 1;
        int ban = left | right | col; // 总限制
        int candidate = ~ban & limit; // 取反，可以表示当前所在行上哪些位置能放置皇后
        int place = 0;
        int ans = 0;
        while (candidate != 0) {
            place = candidate & -candidate; // 提取当前可选位置上最右侧的1
            candidate ^= place; // 将当前位置设置为0，因为已经在当前位置放置皇后了
            ans += f2(limit, (left | place) << 1, (right | place) >> 1, col | place);
        }
        return ans;
    }

    static void main() {
        int n = 14;
        long start, end;
        System.out.println("测试开始");
        System.out.println("解决" + n + "皇后问题");
        start = System.currentTimeMillis();
        System.out.println("方法1答案 : " + totalNQueens1(n));
        end = System.currentTimeMillis();
        System.out.println("方法1运行时间 : " + (end - start) + " 毫秒");

        start = System.currentTimeMillis();
        System.out.println("方法2答案 : " + totalNQueens2(n));
        end = System.currentTimeMillis();
        System.out.println("方法2运行时间 : " + (end - start) + " 毫秒");
        System.out.println("测试结束");

        System.out.println("=======");
        System.out.println("只有位运算的版本，才能10秒内跑完16皇后问题的求解过程");
        start = System.currentTimeMillis();
        int ans = totalNQueens2(16);
        end = System.currentTimeMillis();
        System.out.println("16皇后问题的答案 : " + ans);
        System.out.println("运行时间 : " + (end - start) + " 毫秒");
    }
}
