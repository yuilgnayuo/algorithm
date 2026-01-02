package algo.zuo.code30;

public class Code06_OneKindNumberLessMtimes {

    public int singleNumber(int[] nums) {
        return find(nums, 3);
    }

    // 已知数组中只有1种数出现次数少于m次，其他数都出现了m次
    // 返回出现次数小于m次的那种数
    public int find(int[] nums, int m) {
        // 每个位置有多少个1
        int[] cos = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                cos[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cos[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
