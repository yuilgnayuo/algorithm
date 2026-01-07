package algo.leetcode;

public class P278_firstBadVersion {

    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int v) {
        return v > 1;
    }
}
