package algo.zuo.code50;

// 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
// 测试链接 : https://leetcode.cn/problems/first-missing-positive/
public class Code07_FirstMissingPositive {
    // 时间复杂度O(n)，额外空间复杂度O(1)
    public static int firstMissingPositive(int[] arr) {
        int L = 0, R = arr.length;
        while (L < R) {
            if (arr[L] == L + 1) L++;
            else if (arr[L] <= L || arr[L] > R || arr[arr[L] - 1] == arr[L]) swap(arr, L, --R);
            else swap(arr, L, arr[L] - 1);
        }
        return L + 1;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
