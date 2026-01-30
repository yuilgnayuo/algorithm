package algo.zuo.code50;

import java.util.Arrays;

//  https://leetcode.cn/problems/boats-to-save-people/
public class Code04_BoatsToSavePeople {


    // 时间复杂度O(n * logn)，因为有排序，额外空间复杂度O(1)
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int ans = 0;
        while (l <= r) {
            int sum = l == r ? people[l] : people[l] + people[r];
            if (sum <= limit) l++;
            r--;
            ans++;
        }
        return ans;
    }
}
