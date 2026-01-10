package algo.zuo.code36;


import java.util.ArrayList;
import java.util.List;

// 二叉树的锯齿形层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class Code02_ZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 2001;
    // 使用数组代替队列结构
    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean reverse = false;
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            while (l < r) {
                // 一次遍历一行的数据
                int size = r - l; // 遍历多长，提前计算好，因为每次遍历加入数据的时候都会更改r和l
                List<Integer> levAns = new ArrayList<>();
                // 先收集答案，一次收集一正行的数据
                // reverse = false ：l    -》 r-l
                // reverse = true  : r-l  -》 l
                if (!reverse) {
                    for (int i = l; i < r; i++) {
                        levAns.add(queue[i].val);
                    }
                } else {
                    for (int i = r - 1; i >= l; i--) {
                        levAns.add(queue[i].val);
                    }
                }

                // 然后宽度遍历
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                reverse = !reverse;
                ans.add(levAns);

            }
        }
        return ans;
    }
}
