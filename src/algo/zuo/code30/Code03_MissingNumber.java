package algo.zuo.code30;

/**
 * 没哟出现在数组中的那个数
 */
public class Code03_MissingNumber {

    public int missingNumber(int[] arr) {
        int N = arr.length;
        int eor1 = 0;
        int eor2 = 0;
        for (int i = 0; i < N; i++) {
            eor1 ^= arr[i];
            eor2 ^= i;
        }
        eor2 ^= N;
        return eor1 ^ eor2;
    }
}
