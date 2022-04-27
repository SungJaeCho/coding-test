package dfs;

public class MaximumDepthOfBinaryTree104 {
    public static class TreeNode {
        int val;
        MaximumDepthOfBinaryTree104.TreeNode left;
        MaximumDepthOfBinaryTree104.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, MaximumDepthOfBinaryTree104.TreeNode left, MaximumDepthOfBinaryTree104.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static MaximumDepthOfBinaryTree104.TreeNode treeNode;

    static int result = 0;

    public static void main(String[] args) {
        createNode();
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(MaximumDepthOfBinaryTree104.TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public static void dfs(MaximumDepthOfBinaryTree104.TreeNode node, int depth) {
        if (node == null) {
            if(depth > result) {
                result = depth;
            }
            return;
        } else {
            depth++;
        }
        dfs(node.left, depth);
        dfs(node.right, depth);
    }

//    public static void createNode() {
//        treeNode = new MaximumDepthOfBinaryTree104.TreeNode(3);
//        treeNode.left = new MaximumDepthOfBinaryTree104.TreeNode(9);
//        treeNode.right = new MaximumDepthOfBinaryTree104.TreeNode(20);
//        treeNode.right.left = new MaximumDepthOfBinaryTree104.TreeNode(15);
//        treeNode.right.right = new MaximumDepthOfBinaryTree104.TreeNode(7);
//    }
    public static void createNode() {
        treeNode = new MaximumDepthOfBinaryTree104.TreeNode(1);
        treeNode.left = new MaximumDepthOfBinaryTree104.TreeNode(2);
//        treeNode.right = new MaximumDepthOfBinaryTree104.TreeNode(2);
//        treeNode.right.left = new MaximumDepthOfBinaryTree104.TreeNode(15);
//        treeNode.right.right = new MaximumDepthOfBinaryTree104.TreeNode(7);
    }
}
