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
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.right.left = null;
        root.right.right = null;


        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);


        System.out.println(isBalanced2(root));
    }

    /**
     * 暴力法（自上由下的递归）
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDeep = getDeep(root.left);
        int rightDeep = getDeep(root.right);

        int sub = Math.abs(leftDeep - rightDeep);
        return sub <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    static int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 提前中断法（自下由上的递归）
     */
    public static boolean isBalanced2(TreeNode root) {
        int deep = getDeep2(root);
        System.out.println(deep);
        return deep != -1;
    }

    static int getDeep2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDeep2(root.left);
        if (left == -1) return -1;

        int right = getDeep2(root.right);
        if (right == -1) return -1;

        int sub = Math.abs(left - right);

        if (sub <= 1) {
            return left > right ? left + 1 : right + 1;
        } else {
            return -1;
        }

    }
}
