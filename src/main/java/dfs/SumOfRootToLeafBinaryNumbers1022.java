package dfs;

public class SumOfRootToLeafBinaryNumbers1022 {
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

    static int result = 0;

    public static void main(String[] args) {
        createNode();
        System.out.println(sumRootToLeaf(treeNode));
    }

    public static int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return result;
    }

    public static void dfs(TreeNode node, String val) {
        if(node != null) {
            val += node.val;
            if (node.left == null && node.right == null) {
                System.out.println("val:"+ val);
                result += Integer.parseInt(val, 2);
                return;
            }
            dfs(node.left, val);
            dfs(node.right, val);
        }
    }

//    public static void createNode() {
//        treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(0);
//        treeNode.right = new TreeNode(1);
//        treeNode.left.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(1);
//        treeNode.right.left = new TreeNode(0);
//        treeNode.right.right = new TreeNode(1);
//    }
    public static void createNode() {
        treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
    }
}
