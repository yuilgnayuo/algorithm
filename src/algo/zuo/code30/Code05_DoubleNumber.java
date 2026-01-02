package algo.zuo.code30;

public class Code05_DoubleNumber {

    public int[] singleNumber(int[] nums) {
        int N = nums.length;
        int eor1 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }
        int rightOne = eor1 & (-eor1);
        int eor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor2 ^= num;
            }
        }
        return new int[]{eor2, eor2 ^ eor1};
    }
}
