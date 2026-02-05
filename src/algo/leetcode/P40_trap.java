package algo.leetcode;

import java.util.Stack;

// https://leetcode.cn/problems/trapping-rain-water/
public class P40_trap {

    // 使用单调栈的方式实现
    // i 左边比他大 离它最近的数，以及右边比他大离它最近的在哪？
    //
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            // 当前柱子高于栈顶柱子时，需要计算雨水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int waterHeight = Math.min(height[left], height[i]) - height[bottom];
                int with = i - left - 1;
                ans += with * waterHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
