package algo.leetcode;

public class P389_findTheDifference {

    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tarr = t.toCharArray();
        char ans = 0;
        for (char c : sArr) {
            ans ^= c;
        }
        for (char c : tarr) {
            ans ^= c;
        }
        return ans;
    }

}
