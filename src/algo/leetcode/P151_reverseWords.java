package algo.leetcode;

// https://leetcode.cn/problems/reverse-words-in-a-string/
public class P151_reverseWords {
    static void main() {
        System.out.println(reverseWords("Hello words"));
    }

    public static String reverseWords(String words) {
        String[] s = words.split(" ");
        String res = "";
        for (int i = s.length - 1; i >= 0; i--) {
            String ss = s[i].trim();
            if (!ss.isEmpty()) {
                res = res.concat(s[i].trim()).concat(" ");
            }
        }
        return res.trim();
    }
}
