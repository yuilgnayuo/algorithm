package algo.zuo.code30;


// https://leetcode.cn/problems/single-number/
public class Code04_SingleNumber {

    public int singleNumber(int[] arrs) {
        int eor = 0;
        for (int arr : arrs) {
            eor ^= arr;
        }
        return eor;
    }
}
