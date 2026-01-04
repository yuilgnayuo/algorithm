package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/spiral-matrix/
public class P54_spiralOrder {

    static void main() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4,},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] matrix4 = {
                {1},
                {5},
                {9}
        };
        int[][] matrix3 = {
                {1, 2, 3, 4}
        };
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix4));
        System.out.println(spiralOrder(matrix3));
    }

    // 顺时针旋转输出
    public static List<Integer> spiralOrder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        List<Integer> ans = new ArrayList<>(M * N);
        int left = 0, right = M - 1, up = 0, down = N - 1;
        while (left <= right && up <= down) {
            // left -> right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            // 从上到下和右到左要合法，意味着up一定不能大于down
            if (up <= down) {
                // up -> down
                for (int i = up; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                // right -> left
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            // 从下到上要合法，意味着left一定不能大于right
            if (left <= right) {
                // down -> up
                for (int i = down; i >= up; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
