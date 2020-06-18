package firstRound.L104_MaximumDepthofBinaryTree;


import util.TreeNode;

public class Solution0828 {

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
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int re = Math.max(left, right);
        return re + 1;
    }

    private static int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        int re = Math.max(left, right);
        return re + 1;

    }
}
