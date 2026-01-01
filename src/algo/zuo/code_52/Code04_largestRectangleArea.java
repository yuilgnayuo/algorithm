package algo.zuo.code_52;

/**
 * <a href="http://leetcode.cn/problems/largest-rectangle-in-histogram/">...</a>
 */
public class Code04_largestRectangleArea {
    int MAX = 100001; // 10^5
    int[] stack = new int[MAX];
    int r = 0;

    public int largestRectangleArea(int[] height) {
        int n = height.length;
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
