package dfs;


import org.kohsuke.github.GHCompare;

public class MergeTwoBinaryTrees617 {
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

    public static void main(String[] args) {
        TreeNode root01 = new TreeNode();
        root01 = createNode01(root01);
        TreeNode root02 = new TreeNode();
        root02 = createNode02(root02);
        System.out.println(mergeTrees(root01, root02));
        System.out.println();
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        } else if(root2 == null){
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static TreeNode createNode01(TreeNode tree) {
        tree = new TreeNode(1);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(5);
        return tree;
    }
    public static TreeNode createNode02(TreeNode tree) {
        tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.right = new TreeNode(7);
        return tree;
    }
}

