package algo.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_LetterCombinations {
    static void main() {
        System.out.println(letterCombinations("23"));
    }

    // 思路：
    // 先选 2 的 a → 递归选 3 的 d/e/f → 生成 ad、ae、af
    //回溯换 2 的 b → 生成 bd、be、bf
    //回溯换 2 的 c → 生成 cd、ce、cf
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        Map<Character, String> pm = new HashMap<>();
        pm.put('2', "abc");
        pm.put('3', "def");
        pm.put('4', "ghi");
        pm.put('5', "jkl");
        pm.put('6', "mno");
        pm.put('7', "pqrs");
        pm.put('8', "tuv");
        pm.put('9', "wxyz");
        bk(ans, pm, digits, 0, new StringBuilder());
        return ans;
    }

    private static void bk(List<String> ans, Map<Character, String> pm, String dit, int idx, StringBuilder sb) {
        if (idx == dit.length()) {
            ans.add(sb.toString());
        } else {
            // 当前 idx 是哪个字符
            char curChar = dit.charAt(idx);
            String let = pm.get(curChar);   // 获取字符对应的字母表
            for (int i = 0; i < let.length(); i++) {
                sb.append(let.charAt(i));   // 要当前位置的第一个字符
                bk(ans, pm, dit, idx + 1, sb);  // 你去下个位置继续尝试把
                sb.deleteCharAt(idx);   // 当前位置需要清除 ，继续尝试 let 的下一个位置
            }
        }
    }
}
