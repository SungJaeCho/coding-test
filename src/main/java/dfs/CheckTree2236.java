package dfs;


public class CheckTree2236 {
    public static class TreeNode {
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

    static TreeNode treeNode;

    static int sum = 0;
    public static void main(String[] args) {
        createNode();
        System.out.println(checkTree(treeNode));
    }

    public static boolean checkTree(TreeNode root) {
        dfs(root);
        if(root.val == sum- root.val) {
            return true;
        } else {
            return false;
        }
    }

    public static void dfs(TreeNode node) {
        if(node == null) return;
        sum += node.val;
        dfs(node.left);
        dfs(node.right);
    }

    public static void createNode() {
        treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(1);
    }
}

