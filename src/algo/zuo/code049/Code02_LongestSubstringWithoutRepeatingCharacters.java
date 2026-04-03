package algo.zuo.code049;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// 测试链接 : https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class Code02_LongestSubstringWithoutRepeatingCharacters {
    // 使用Set记录是否当前字符重复
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> map = new HashSet<>();
        // 来到i位置，往左看最大能扩的长度，用map来记录字符串。
        int max = 0;
        for (int cur, i = 0; i < s.length(); i++) {
            cur = i;
            while (cur >= 0) {
                char curChar = s.charAt(cur);
                if (map.contains(curChar)) {
                    break;
                }
                map.add(curChar);
                cur--;
            }
            max = Math.max(max, map.size());
            map.clear();
        }
        return max;
    }
    // 使用HashMap记录上次出现位置
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int L = 0;
        // adbc abc bb
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                L = Math.max(L, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - L + 1);
        }
        return max;
    }
    // 使用数组记录上次出现位置
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            l = Math.max(l, last[chars[r]] + 1); // 左边l和当前字符上次所在位置进行pk
            ans = Math.max(ans, r - l + 1);  // 求当前最大值
            last[chars[r]] = r; // 更新r出现的位置
        }
        return ans;
    }
}
