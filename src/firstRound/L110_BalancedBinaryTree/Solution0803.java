package firstRound.L110_BalancedBinaryTree;


import util.TreeNode;


public class Solution0803 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.right.left = null;
        root.right.right = null;


        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);


        System.out.println(isBalanced(root));
    }


    public static boolean isBalanced(TreeNode root) {

        int re = getDeep(root);

        return re != -1;
    }

    static int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDeep(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDeep(root.right);
        if (right == -1) {
            return -1;
        }
        int sub = Math.abs(left - right);
        if (sub > 1) {
            return -1;
        }
        return left > right ? left + 1 : right + 1;
    }
}
