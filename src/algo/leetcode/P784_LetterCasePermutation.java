package algo.leetcode;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/letter-case-permutation/
// 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
public class P784_LetterCasePermutation {

    public List<String> letterCasePermutation(String letter) {
        List<String> ans = new ArrayList<>();
        f(letter, 0, ans);
        return ans;
    }

    private void f(String letter, int i, List<String> ans) {
        if (i == letter.length()) {
            ans.add(letter);
            return;
        }
        // low -> up
        if (letter.charAt(i) >= 'a' && letter.charAt(i) <= 'z') {
            letter = modifyCharAtIndex(letter, i, Character.toUpperCase(letter.charAt(i)));
            f(letter, i + 1, ans);
            letter = modifyCharAtIndex(letter, i, Character.toLowerCase(letter.charAt(i)));
            f(letter, i + 1, ans);
        } else if (letter.charAt(i) >= 'A' && letter.charAt(i) <= 'Z') { // up -> low
            letter = modifyCharAtIndex(letter, i, Character.toLowerCase(letter.charAt(i)));
            f(letter, i + 1, ans);
            letter = modifyCharAtIndex(letter, i, Character.toUpperCase(letter.charAt(i)));
            f(letter, i + 1, ans);
        } else {
            // digit
            f(letter, i + 1, ans);
        }
    }

    private static String modifyCharAtIndex(String source, int index, char newChar) {
        if (source == null || index < 0 || index >= source.length()) {
            return source;
        }
        char[] chars = source.toCharArray();
        chars[index] = newChar;
        return new String(chars);
    }
}
