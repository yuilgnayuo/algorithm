package algo.zuo.code31;

// 给你两个整数 left 和 right ，表示区间 [left, right]
// 返回此区间内所有数字 & 的结果
// 包含 left 、right 端点
// 测试链接 : https://leetcode.cn/problems/bitwise-and-of-numbers-range/
public class Code04_LeftToRightAnd {

    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            // 每次都减去最右侧的1，直到 left = right
            right -= right & -right;
            // 每次减去1，进行异或直到 left = right
//            right = right & (right - 1);
        }
        return right;
    }

}
