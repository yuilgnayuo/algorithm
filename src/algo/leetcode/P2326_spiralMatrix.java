package algo.leetcode;

import utils.MatrixPrinter;

// https://leetcode.cn/problems/spiral-matrix-iv/
public class P2326_spiralMatrix {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static void main() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        int[][] res = spiralMatrix(3, 3, l1);
        MatrixPrinter.printMatrix(res);
    }

    static ListNode root = null;

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        root = head;
        spiralOrder(ans);
        return ans;
    }

    public static void spiralOrder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int left = 0, right = M - 1, up = 0, down = N - 1;
        while (left <= right && up <= down) {
            // left -> right
            for (int i = left; i <= right; i++) {
                matrix[up][i] = getNext();
            }
            up++;
            // 从上到下和右到左要合法，意味着up一定不能大于down
            if (up <= down) {
                // up -> down
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = getNext();
                }
                right--;
                // right -> left
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = getNext();
                }
                down--;
            }
            // 从下到上要合法，意味着left一定不能大于right
            if (left <= right) {
                // down -> up
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = getNext();
                }
                left++;
            }
        }
    }

    private static int getNext() {
        int val = -1;
        if (root != null) {
            val = root.val;
            root = root.next;
        }
        return val;
    }
}
