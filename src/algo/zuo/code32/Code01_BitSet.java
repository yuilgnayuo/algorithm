package algo.zuo.code32;

import java.util.HashSet;

// 實現位圖
public class Code01_BitSet {

    public static class Bitset {
        int[] set;

        ///  1 ~ n-1
        public Bitset(int n) {
            //  a/b 需要向上取整，(a + b - 1)/b
            set = new int[(n + 32 - 1) / 32];
        }

        // 把num加入到位图
        void add(int num) {
            int idx = num / 32;
            int bit = num % 32;
            set[idx] |= 1 << bit;
        }

        // 把num从位图中删除
        void remove(int num) {
            set[num / 32] &= ~(1 << num % 32);
        }

        // 如果位图里没有num，就加入；如果位图里有num，就删除
        // 0^1 => 1, 1^1 = 0
        void reverse(int num) {
            set[num / 32] ^= 1 << num % 32;
        }

        // 查询num是否在位图中
        boolean contains(int num) {
            return ((set[num / 32] >> (num % 32)) & 1) == 1;
        }
    }

    static void main() {
        int n = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        // 实现的位图结构
        Bitset bitSet = new Bitset(n);
        // 直接用HashSet做对比测试
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("调用阶段开始");
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            // number -> 0 ~ n-1，等概率得到
            int number = (int) (Math.random() * n);
            if (decide < 0.333) {
                bitSet.add(number);
                hashSet.add(number);
            } else if (decide < 0.666) {
                bitSet.remove(number);
                hashSet.remove(number);
            } else {
                bitSet.reverse(number);
                if (hashSet.contains(number)) {
                    hashSet.remove(number);
                } else {
                    hashSet.add(number);
                }
            }
        }
        System.out.println("调用阶段结束");
        System.out.println("验证阶段开始");
        for (int i = 0; i < n; i++) {
            if (bitSet.contains(i) != hashSet.contains(i)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("验证阶段结束");
        System.out.println("测试结束");
    }
}
