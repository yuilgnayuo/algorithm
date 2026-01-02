package algo.zuo.code31;

// https://leetcode.cn/problems/power-of-two/
public class Code01_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n & -n);
    }
}
