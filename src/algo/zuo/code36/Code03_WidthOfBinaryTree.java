package algo.zuo.code36;

// https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
public class Code03_WidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 3001;
    // 使用数组代替队列结构
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static Integer[] iq = new Integer[MAXN];

    public static int l, r;

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root != null) {
            l = r = 0;
            queue[r] = root;
            iq[r++] = 1;
            while (l < r) {
                // 一次遍历一行的数据
                int size = r - l; // 遍历多长，提前计算好，因为每次遍历加入数据的时候都会更改r和l
                // 当前正行的开始位置l，结束位置 r - 1
                ans = Math.max(ans, iq[r - 1] - iq[l] + 1);
                // 然后宽度遍历
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l];
                    Integer idx = iq[l++];
                    if (cur.left != null) {
                        queue[r] = cur.left;
                        iq[r++] = idx * 2;
                    }
                    if (cur.right != null) {
                        queue[r] = cur.right;
                        iq[r++] = idx * 2 + 1;
                    }
                }
            }
        }
        return ans;
    }
}
