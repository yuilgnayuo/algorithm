package algo.zuo.code50;


import java.util.Arrays;

// 供暖器
// 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置
// 请你找出并返回可以覆盖所有房屋的最小加热半径。
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
// 测试链接 : https://leetcode.cn/problems/heaters/
public class Code06_Heaters {

    // 时间复杂度O(n * logn)，因为有排序，额外空间复杂度O(1)
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            // 当前如果不是最优的，那么j++ 跳向下一个位置
            while (!best(houses, heaters, i, j)) {
                j++;
            }
            ans = Math.max(ans, Math.abs(houses[i] - heaters[j]));
        }
        return ans;
    }

    // 当前来到地点：housese【i】由heaters【j】供暖为：a
    // 当前来到地点：housese【i】由heaters【j+1】供暖为：b
    // 当 a <  b时，此时为最优解否则不是，j++
    private static boolean best(int[] houses, int[] heaters, int i, int j) {
        return j == heaters.length - 1  // 如果j来到了最后一个位置，说明这就是最优解
                ||                      // 否则比较 a 和 b的值
                Math.abs(houses[i] - heaters[j]) < Math.abs(houses[i] - heaters[j + 1]);
    }
}
