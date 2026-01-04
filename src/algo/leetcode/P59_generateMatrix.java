package algo.leetcode;

import utils.MatrixPrinter;

// https://leetcode.cn/problems/spiral-matrix-ii/
public class P59_generateMatrix {

    static void main() {
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        // n * n
        int[][] ans = new int[n][n];
        spiralOrder(ans);
        MatrixPrinter.printMatrix(ans);
        return ans;
    }

    public static void spiralOrder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int val = 0;
        int left = 0, right = M - 1, up = 0, down = N - 1;
        while (left <= right && up <= down) {
            // left -> right
            for (int i = left; i <= right; i++) {
                matrix[up][i] = ++val;
            }
            up++;
            // 从上到下和右到左要合法，意味着up一定不能大于down
            if (up <= down) {
                // up -> down
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = ++val;
                }
                right--;
                // right -> left
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = ++val;
                }
                down--;
            }
            // 从下到上要合法，意味着left一定不能大于right
            if (left <= right) {
                // down -> up
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = ++val;
                }
                left++;
            }
        }
    }
}
