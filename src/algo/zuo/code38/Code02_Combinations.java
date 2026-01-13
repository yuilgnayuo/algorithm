package algo.zuo.code38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的组合
// 答案 不能 包含重复的组合。返回的答案中，组合可以按 任意顺序 排列
// 注意其实要求返回的不是子集，因为子集一定是不包含相同元素的，要返回的其实是不重复的组合
// 比如输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 测试链接 : https://leetcode.cn/problems/subsets-ii/
public class Code02_Combinations {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        if (i == nums.length) {
            // 收集答案，size长度，path中就是需要的结果
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                res.add(path[j]);
            }
            ans.add(res);
        } else {
            int j = i + 1; // 来到下一个位置，并且计算下一个不相同数据的位置
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            // 不要当前位置的数据，然后去下一个位置递归去吧
            f(nums, j, path, size, ans);
            // 要 x 个当前的数据，要1个，2个...然后递归去吧
            for (; i < j; i++) {
                path[size++] = nums[i];
                f(nums, j, path, size, ans);
            }
        }
    }
}
