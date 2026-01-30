package algo.zuo.code50;


// https://leetcode.cn/problems/container-with-most-water/
public class Code05_ContainerWithMostWater {

    // 时间复杂度O(n)，额外空间复杂度O(1)
    public static int maxArea(int[] height) {
        int ans = 0, n = height.length;
        for (int l = 0, r = n - 1; l < r; ) { // l != r 否则容量为0
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return ans;
    }
}
