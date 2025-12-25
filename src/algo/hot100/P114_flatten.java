package algo.hot100;


import java.util.ArrayList;
import java.util.List;

public class P114_flatten {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new P114_flatten().flatten(root);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        resver(root, list);

        // for (int i = 0; i < list.size(); i++) {
        //     TreeNode cur = new TreeNode(list.get(i));
        //     curN.right = cur;
        //     curN = cur;
        // }

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1), cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }

    public void resver(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        if (root.left != null) {
            resver(root.left, list);
        }
        if (root.right != null) {
            resver(root.right, list);
        }
    }


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
