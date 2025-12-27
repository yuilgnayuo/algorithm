package algo.hot100;

import utils.MatrixPrinter;

public class P221_MaxSq {

    public static void main(String[] args) {
        char[][] ma = {{'0', '1', '1'}, {'1', '1', '1'}, {'0', '1', '1'}};
        int[][] matrix1 = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};

        char[][] matrix = {{'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}};
        System.out.println(new P221_MaxSq().maximalSquare(matrix));
    }

    // 暴力解，超时
    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int len = 0;
                while ((j + len) < M && (i + len) < N &&
                        matrix[i + len][j] == '1' && matrix[i][j + len] == '1') {
                    if (allIs(matrix, i, j, len)) {
                        max = Math.max(max, (len + 1) * (len + 1));
                    }
                    len++;
                }
            }
        }
        return max;
    }

    // n * m
    // from st ~ end the all of is 1
    public boolean allIs(char[][] martix, int ns, int ms, int len) {
        if (len == 0) return martix[ns][ms] != 0;
        int nd = ns + len;
        int md = ms + len;
        for (int i = ns; i <= nd; i++) {
            for (int j = ms; j <= md; j++) {
                if (martix[i][j] == '0') return false;
            }
        }
        return true;
    }

    // dp解，以dp【i】【j】为右下脚的，所能组成的最大的正方形。
    // 只有当 左边，上方，左斜上方，都为相等的数，时，右下如果为1那么所能组成的最大正方形就是前面一个格子值+1的乘积
    // 关键：动态转移方程：以i，j位置为右下脚的最大正方形的边长。
    // dp(i,j) = min(左边，上边，左上);
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        MatrixPrinter.printMatrix(dp);
        return maxLen * maxLen;
    }

}
