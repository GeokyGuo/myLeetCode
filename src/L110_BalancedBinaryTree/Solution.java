package L110_BalancedBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
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

        System.out.println(isBalanced(root));
    }

    public static int isBalanced(TreeNode root) {
        return 0;
    }



}
