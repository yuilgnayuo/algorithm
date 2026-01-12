package algo.zuo.code36;

// 求二叉树的最大、最小深度
public class Code04_DepthOfBinaryTree {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // max depth
    // https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 测试链接 : https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        // 当前为空树
        if (root == null) return 0;
        // 到达叶子节点
        if (root.left == null && root.right == null) return 1;
        // 左树求最小，右树求最小
        int ml = Integer.MAX_VALUE;
        if (root.left != null) {
            ml = minDepth(root.left);
        }
        int mr = Integer.MAX_VALUE;
        if (root.right != null) {
            mr = minDepth(root.right);
        }
        // 收集最小答案
        return Math.min(ml, mr) + 1;
    }
}
