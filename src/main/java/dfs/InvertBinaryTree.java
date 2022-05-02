package dfs;

import org.kohsuke.github.GHCompare;

public class InvertBinaryTree {
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


    public static void main(String[] args) {
        createNode2();
        checkTree(treeNode);
        System.out.println("END");
    }

    public static TreeNode checkTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public static void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }

    public static void createNode() {
        treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
    }
    public static void createNode2() {
        treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
    }
}
