package algo.zuo.code38;

import java.util.Stack;

// 用递归函数逆序栈
public class Code05_ReverseStackWithRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int bot = bottomOut(stack);
        reverse(stack);
        stack.push(bot);
    }

    private static int bottomOut(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.isEmpty()) return ans;
        int latest = bottomOut(stack);
        stack.push(ans);
        return latest;
    }

    static void main() {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        reverse(stack);
        System.out.println(stack);
    }
}
