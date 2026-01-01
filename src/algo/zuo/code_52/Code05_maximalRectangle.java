package algo.zuo.code_52;

public class Code05_maximalRectangle {

    static void main() {
        char[][] m = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new Code05_maximalRectangle().maximalRectangle(m));
    }

    int MAX = 201; // 10^5
    int[] stack = new int[MAX];
    int[] height = new int[MAX];
    int r;

    public int maximalRectangle(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            ans = Math.max(ans, largestRectangleArea(M));
        }
        return ans;
    }

    private int largestRectangleArea(int n) {
        r = 0;
        int ans = 0, cur, left;
        for (int i = 0; i < n; i++) {
            while (r > 0 && height[stack[r - 1]] >= height[i]) {
                cur = stack[--r];
                left = r > 0 ? stack[r - 1] : -1;
                ans = Math.max(ans, (i - left - 1) * height[cur]);
            }
            stack[r++] = i;
        }
        while (r > 0) {
            cur = stack[--r];
            left = r > 0 ? stack[r - 1] : -1;
            // 此时最右边就是当前数组的长度：n
            ans = Math.max(ans, (n - left - 1) * height[cur]);
        }
        return ans;
    }
}
