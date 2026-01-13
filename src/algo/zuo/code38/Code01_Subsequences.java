package algo.zuo.code38;

import java.util.HashSet;
import java.util.Set;

// 字符串的全部子序列
// 子序列本身是可以有重复的，只是这个题目要求去重
// 测试链接 : https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
public class Code01_Subsequences {

    public static String[] generatePermutation1(String str) {
        char[] array = str.toCharArray();
        Set<String> set = new HashSet<>();
        f(array, 0, new StringBuilder(), set);
        String[] ans = new String[set.size()];
        int idx = 0;
        for (String s : set) {
            ans[idx++] = s;
        }
        return ans;
    }

    // s[i...]，之前决定的路径path，set收集结果时去重
    private static void f(char[] array, int idx, StringBuilder path, Set<String> set) {
        if (idx == array.length) {
            set.add(path.toString());
        } else {
            path.append(array[idx]); // 加入当前字符，然后递归去下一个位置吧
            f(array, idx + 1, path, set);
            path.deleteCharAt(path.length() - 1);  // 不要当前字符，然后递归去下一个位置吧
            f(array, idx + 1, path, set);
        }
    }

    // 解法2: 使用数组结构代替SB
    public static String[] generatePermutation2(String str) {
        char[] s = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        f2(s, 0, new char[s.length], 0, set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }

    private static void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
        if (i == s.length) {
            set.add(String.valueOf(path, 0, size)); // 收集答案，0～size-1 的字符
        } else {
            path[size] = s[i]; // 先加入当前字符到path上
            f2(s, i + 1, path, size + 1, set); // size + 1 要当前位置数据
            f2(s, i + 1, path, size, set);          // size 不动 不要当前位置的数据
        }
    }
}
