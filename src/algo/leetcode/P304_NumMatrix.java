package algo.leetcode;

public class P304_NumMatrix {
    static void main() {
        var matrix = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };
        var nm = new NumMatrix(matrix);
        var nm1 = new NumMatrix1(matrix);
        System.out.println(nm.sumRegion(1, 1, 3, 3));
        System.out.println(nm1.sumRegion(1, 1, 3, 3));
    }

    static class NumMatrix1 {
        int[][] matrix;

        public NumMatrix1(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ans += matrix[i][j];
                }
            }
            return ans;
        }
    }

    static class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int N = matrix.length;
            int M = matrix[0].length;
            sums = new int[N][M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
//            MatrixPrinter.printMatrix(sums);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                ans += sums[i][col2 + 1] - sums[i][col1];
            }
            return ans;
        }
    }
}
