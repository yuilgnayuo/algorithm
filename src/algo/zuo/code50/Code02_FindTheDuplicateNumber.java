package algo.zuo.code50;


// 测试链接 : https://leetcode.cn/problems/find-the-duplicate-number/
public class Code02_FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
