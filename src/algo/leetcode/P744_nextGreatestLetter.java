package algo.leetcode;


public class P744_nextGreatestLetter {
    static void main() {

        System.out.println(nextGreatestLetter(new char[]{'a', 'c', 'f'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length, l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}
