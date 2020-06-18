package firstRound.L104_MaximumDepthofBinaryTree;


import util.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(3);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.left = new TreeNode(4);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        int max = 0;
        max = maxDepth(root, max);
        return max;
    }

    static int maxDepth(TreeNode root, int max) {
        if (root == null) return max;
        max += 1;

        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        return left > right ? left : right;
    }
}
