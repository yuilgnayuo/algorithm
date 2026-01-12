package algo.zuo.code36;


// 求完全二叉树的节点个数
// 测试链接 : https://leetcode.cn/problems/count-complete-tree-nodes/
public class Code09_CountCompleteTreeNodes {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 暴力解，直接递归调用
    public int countNodes(TreeNode root) {
        return f(root);
    }

    private int f(TreeNode root) {
        if (root == null) return 0;
        return f(root.left) + f(root.right) + 1;
    }

    // 左神解：根据完全二叉树的性质求解
    public static int countNodes1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return f(head, 1, mostLeft(head, 1));
    }

    // cur : 当前来到的节点
    // level :  当前来到的节点在第几层
    // h : 整棵树的高度，不是cur这棵子树的高度
    // 求 : cur这棵子树上有多少节点
    public static int f(TreeNode cur, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeft(cur.right, level + 1) == h) {
            // cur右树上的最左节点，扎到了最深层
            return (1 << (h - level)) + f(cur.right, level + 1, h);
        } else {
            // cur右树上的最左节点，没扎到最深层
            return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
        }
    }

    // 当前节点是cur，并且它在level层
    // 返回从cur开始不停往左，能扎到几层
    public static int mostLeft(TreeNode cur, int level) {
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level - 1;
    }
}
