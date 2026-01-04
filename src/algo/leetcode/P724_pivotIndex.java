package algo.leetcode;

import java.util.Arrays;

public class P724_pivotIndex {
    static void main() {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        // 左右相等，那么在数组中就是：
        // sum = total - nums[i] - sum => 2 * sum + nums[i] == total
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
