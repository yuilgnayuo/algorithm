package algo.zuo.code32;

// https://leetcode.cn/problems/design-bitset/
public class Code02_DesignBitset {

    class Bitset {
        int[] set;
        int zero;
        int one;
        int size;
        boolean reverse; // 標記是否反轉了

        public Bitset(int n) {
            set = new int[(n + 31) / 32];
            reverse = false;
            zero = n;
            size = n;
            one = 0;
        }

        // 将下标为 idx 的位上的值更新为 1 。
        // 如果值已经是 1 ，则不会发生任何改变。
        public void fix(int i) {
            int idx = i / 32;
            int bit = i % 32;
            int jud = 1 << bit;
            // 沒有反轉
            if (!reverse) {
                // 0: 不存在，1:存在
                if ((set[idx] & jud) == 0) {
                    set[idx] |= jud;
                    one++;
                    zero--;
                }
            } else {
                // 反轉之後所有位置變為：0-》1，1=》0
                // 反轉之後：0:存在，1:不存在
                if ((set[idx] & jud) != 0) {
                    one++;
                    zero--;
                    set[idx] ^= jud;
                }
            }
        }

        // 将下标为 idx 的位上的值更新为 0 。
        // 如果值已经是 0 ，则不会发生任何改变。
        public void unfix(int i) {
            int idx = i / 32;
            int bit = i % 32;
            int jud = 1 << bit;
            // 沒有反轉
            if (!reverse) {
                // 0: 不存在，1:存在
                if ((set[idx] & jud) != 0) {
                    set[idx] ^= jud;
                    one--;
                    zero++;
                }
            } else {
                // 反轉之後所有位置變為：0-》1，1=》0
                // 反轉之後：0:存在，1:不存在
                if ((set[idx] & jud) == 0) {
                    one--;
                    zero++;
                    set[idx] |= jud;
                }
            }
        }

        // 不需要真正的把所有位都反轉，而是在fix和unfix以及toString的時候
        // 根據狀態來判斷是否反轉了
        public void flip() {
            int tmp = zero;
            zero = one;
            one = tmp;
            reverse = !reverse;
        }

        public boolean all() {
            return one == size;
        }

        public boolean one() {
            return one > 0;
        }

        public int count() {
            return one;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, k = 0, number; i < size; k++) {
                number = set[k];
                for (int j = 0; j < 32 && i < size; j++, i++) {
                    int s = number >> j & 1;
                    s ^= reverse ? 1 : 0; // 反轉之後：1-》0，0-〉1
                    sb.append(s);
                }
            }
            return sb.toString();
        }
    }
}
