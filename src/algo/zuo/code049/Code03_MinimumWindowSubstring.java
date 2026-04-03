package algo.zuo.code049;


// 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
// 测试链接 : https://leetcode.cn/problems/minimum-window-substring/
public class Code03_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        char[] sc = s.toCharArray();
        char[] target = t.toCharArray();
        int[] cnt = new int[256];
        for (char tc : target) {
            cnt[tc]--;
        }
        int debt = target.length;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < sc.length; r++) {
            if (cnt[sc[r]]++ < 0) // 当前字符是target中的字符，更新debt
                debt--;
            if (debt == 0) {    // 此时看一下是否能够扩大l。
                while (cnt[sc[l]] > 0) {  // 窗口最左侧向右扩
                    cnt[sc[l++]]--;     // 不要忘记收回这个字符
                }
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
