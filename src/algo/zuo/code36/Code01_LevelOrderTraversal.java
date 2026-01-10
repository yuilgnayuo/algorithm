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

    // 不是最优解
    public List<List<Integer>> levelOrder1(TreeNode root) {
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

    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 2001;
    // 使用数组代替队列结构
    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            while (l < r) {
                // 一次遍历一行的数据
                int size = r - l; // 遍历多长，提前计算好，因为每次遍历加入数据的时候都会更改r和l
                List<Integer> levAns = new ArrayList<>();
//                for (int i = l; i < r ; i++) {
//                    levAns.add(queue[i].val);
//                }
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    levAns.add(cur.val);
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(levAns);

            }
        }
        return ans;
    }
}
