package algo.leetcode;

public class P34_searchRange {

    public int[] searchRange(int[] nums, int target) {
        int f = search(nums, target);
        int e = search(nums, target + 1) - 1;
        if (f >= nums.length || nums[f] != target)
            return new int[]{-1, -1};
        else return new int[]{f, e};
    }

    private int search(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
