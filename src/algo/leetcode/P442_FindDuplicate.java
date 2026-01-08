package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P442_FindDuplicate {
    static void main() {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    ///
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] seen = new boolean[nums.length + 5];
        for (int num : nums) {
            if (seen[num]) {
                res.add(num);
            } else {
                seen[num] = true;
            }
        }
        return res;
    }
}
