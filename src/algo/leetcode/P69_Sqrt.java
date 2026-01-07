package algo.leetcode;

// https://leetcode.cn/problems/sqrtx/
// 求一個數的平方
public class P69_Sqrt {
    static void main() {
        System.out.println(mySqrt(8));
    }

    // 對於x一定有：sqrt == x / sqrt,並且 sqrt一定是在0～X之間
    // 思路：使用二分法，
    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return sqrt;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}
