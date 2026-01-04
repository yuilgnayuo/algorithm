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
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] sums = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sums[i][j + 1] = sums[i][j] + mat[i][j];
            }
        }
        MatrixPrinter.printMatrix(sums);
        int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int row1 = Math.max((i - k), 0);
                int row2 = Math.min((i + k), N - 1);
                int col1 = Math.max((j - k), 0);
                int col2 = Math.min((j + k), M - 1);
                ans[i][j] = sumRegion(row1, col1, row2, col2, sums);
            }
        }
        return ans;
    }

    public static int sumRegion(int row1, int col1, int row2, int col2, int[][] sums) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans += sums[i][col2 + 1] - sums[i][col1];
        }
        return ans;
    }
}
