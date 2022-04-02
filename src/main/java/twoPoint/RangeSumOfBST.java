package twoPoint;


public class RangeSumOfBST {
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
        dfs(treeNode, 6, 10);
        System.out.println(sum);
    }

    public static void dfs(TreeNode node, int low, int high) {
        if(node == null) return;

        if(node.val >= low && node.val <= high) {
            sum += node.val;
        }
        if(node.val > low) dfs(node.left, low, high);
        if(node.val < high) dfs(node.right, low, high);
    }

    public static void createNode() {
        treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(18);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.left.right.left = new TreeNode(6);
    }
}

