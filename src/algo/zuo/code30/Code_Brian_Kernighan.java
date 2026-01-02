package algo.zuo.code30;

public class Code_Brian_Kernighan {
    static void main() {
        System.out.println(getRightOne(12));
        System.out.println(Integer.toBinaryString(getRightOne(12)));
    }

    static int getRightOne(int n) {
        return n & (-n);
    }

    static int getRightOne2(int n) {
        return n & ~(n-1);
    }
}
