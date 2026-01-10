package algo.zuo.code36;

import java.util.*;

// 二叉树的层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class Code01_LevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            HashMap<TreeNode, Integer> levs = new HashMap<>();
            queue.add(root);
            levs.put(root, 0);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int lev = levs.get(cur);
                if (ans.size() == lev) {
                    // init lev ans
                    ans.add(new ArrayList<>());
                }
                ans.get(lev).add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                    levs.put(cur.left, lev + 1);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    levs.put(cur.right, lev + 1);
                }
            }
        }
        return ans;
    }
}
