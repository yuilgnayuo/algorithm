package algo.zuo.code36;

// 验证完全二叉树
// 测试链接 : https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
public class Code08_CompletenessOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 101;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    // 完全二叉树：非叶子节点一定是满树
    // 叶子节点，并且它是最后一个节点的情况下：左叶子一定不能为空，右可以为空
    public static boolean isCompleteTree(TreeNode h) {
        if (h == null) {
            return true;
        }
        r = l = 0;
        queue[r++] = h;
        boolean leaf = false;
        while (l < r) {
            h = queue[l++];
            // 第一个条件：如果左为空，右不为空，那么一定不是
            if ((h.left == null && h.right != null)
                    || (leaf && (h.left != null || h.right != null))) {
                return false;
            }
            if (h.left != null) {
                queue[r++] = h.left;
            }
            if (h.right != null) {
                queue[r++] = h.right;
            }
            if (h.left == null || h.right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
