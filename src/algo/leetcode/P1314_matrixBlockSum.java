package algo.leetcode;

import utils.MatrixPrinter;

public class P1314_matrixBlockSum {

    static void main() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixPrinter.printMatrix(matrixBlockSum(mat, 1));
        MatrixPrinter.printMatrix(matrixBlockSum1(mat, 1));
    }

    // 思路：暴力枚举不可行
    // 使用一维数组的前缀和，sum代表每行的前缀和
    // 只需要遍历确定矩阵的每行，那么就只需要计算从row1到row2之间的和
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int N = mat.length; // n行
        int M = mat[0].length;  // m列
        int[][] sums = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sums[i][j + 1] = sums[i][j] + mat[i][j];
            }
        }
//        MatrixPrinter.printMatrix(sums);
        int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int row1 = Math.max((i - k), 0);        // 上边界
                int row2 = Math.min((i + k), N - 1);    // 下边界
                int col1 = Math.max((j - k), 0);        // 左边界
                int col2 = Math.min((j + k), M - 1);    // 右边界
                ans[i][j] = sumRegion(row1, col1, row2, col2, sums);
            }
        }
        return ans;
    }

    // 遍历确定矩阵大小的每一行
    public static int sumRegion(int row1, int col1, int row2, int col2, int[][] sums) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            // 从i行开始，到col2+1 - col1列
            ans += sums[i][col2 + 1] - sums[i][col1];
        }
        return ans;
    }

    // 最优解是二维数组前缀和：
    // 公式：pre[i][j] = mat[i-1][j-1] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1]
    // 任意区域和公式：左上角 (x1,y1)、右下角 (x2,y2)
    // sum = pre[x2+1][y2+1] - pre[x1][y2+1] - pre[x2+1][y1] + pre[x1][y1]
    public static int[][] matrixBlockSum1(int[][] mat, int k) {
        int N = mat.length;     // n行
        int M = mat[0].length;  // m列
        int[][] pre = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }
//        MatrixPrinter.printMatrix(pre);
        int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int row1 = Math.max((i - k), 0);        // 上边界
                int row2 = Math.min((i + k), N - 1);    // 下边界
                int col1 = Math.max((j - k), 0);        // 左边界
                int col2 = Math.min((j + k), M - 1);    // 右边界
                ans[i][j] = pre[row2 + 1][col2 + 1]
                        - pre[row1][col2 + 1]
                        - pre[row2 + 1][col1]
                        + pre[row1][col1];
            }
        }
        return ans;
    }
}
