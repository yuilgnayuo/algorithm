package algo.zuo.code50;


public class Code01_SortArrayByParityII {

    static void main() {
        sortArrayByParityII(new int[]{4, 2, 5, 7});
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int N = nums.length;
        for (int even = 0, odd = 1; odd < N && even < N; ) {
            if ((nums[N - 1] & 1) == 1) { // odd
                swap(nums, odd, N - 1);
                odd += 2;
            } else { //even
                swap(nums, even, N - 1);
                even += 2;
            }
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
