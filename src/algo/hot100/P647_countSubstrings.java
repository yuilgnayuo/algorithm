package algo.hot100;

/**
 * 回文子串
 */
public class P647_countSubstrings {
    public static void main(String[] args) {
        System.out.println(new P647_countSubstrings().countSubstrings("abc"));
    }

    public int countSubstrings(String str) {
        if (str == null || str.isEmpty()) return 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += range(i, i, str);
            ans += range(i, i+1, str);
        }
        return ans;
    }
    private int range(int l, int r, String sr) {
        int ans = 0;
        while (l >= 0 && r < sr.length() && sr.charAt(l) == sr.charAt(r)) {
            l--;
            r++;
            ans++;
        }
        return ans;
    }
}
