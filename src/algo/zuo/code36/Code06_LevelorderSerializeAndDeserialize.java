package algo.zuo.code36;

// 二叉树按层序列化和反序列化
// 测试链接 : https://leetcode.cn/problems/h54YBf/description/
public class Code06_LevelorderSerializeAndDeserialize {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public class Codec {
        public static int MAXN = 10001;

        public static TreeNode[] queue = new TreeNode[MAXN];

        public static int l, r;

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root != null) {
                l = r = 0;
                queue[r++] = root;
                sb.append(root.val).append(",");
                while (l < r) {
                    root = queue[l++];
                    if (root.left != null) {
                        queue[r++] = root.left;
                        sb.append(root.left.val).append(",");
                    } else {
                        sb.append("#,");
                    }
                    if (root.right != null) {
                        queue[r++] = root.right;
                        sb.append(root.right.val).append(",");
                    } else {
                        sb.append("#,");
                    }
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if ("".equals(data)) return null;
            String[] datas = data.split(",");
            int idx = 0;
            l = r = 0;
            TreeNode head = g(datas[idx++]);
            queue[r++] = head;
            while (l < r) {
                TreeNode cur = queue[l++];
                cur.left = g(datas[idx++]);
                cur.right = g(datas[idx++]);
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            return head;
        }

        private TreeNode g(String cur) {
            return "#".equals(cur) ? null : new TreeNode(Integer.parseInt(cur));
        }
    }
}
