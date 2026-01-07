package algo.leetcode;

public class P540_singleNonDuplicate {
    static void main() {
        int[] nums = new int[]{3, 3, 5, 5, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7}));
    }

    ///  不是最優解，因為需要遍歷整個數組
    public int singleNonDuplicate1(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }

    // 使用二分查找，時間複雜度為 O(logN)
    // 難點：找到第一個相同的數，核心：if (m % 2 == 1) m--；=》保證相等的數一定在奇數位
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
