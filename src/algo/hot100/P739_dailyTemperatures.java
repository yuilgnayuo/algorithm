package algo.hot100;

import java.util.Arrays;
import java.util.Stack;

public class P739_dailyTemperatures {
    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new P739_dailyTemperatures().dailyTemperatures(t)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < cur) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
