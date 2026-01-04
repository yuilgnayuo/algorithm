package algo.leetcode;

public class P303_NumArray {

    static void main() {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(arr);
        System.out.println(array.sumRange(0, 2));

        int[] arr2 = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray2 array2 = new NumArray2(arr);
        System.out.println(array2.sumRange(0, 2));
    }

    static class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int ans = 0;
            while (left <= right) {
                ans += this.nums[left];
                left++;
            }
            return ans;
        }
    }

    static class NumArray2 {
        int[] sums;
        public NumArray2(int[] nums) {
            this.sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }
        public int sumRange(int left, int right) {
            return this.sums[right + 1] - sums[left];
        }
    }

}
