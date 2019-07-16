package L101_SymmetricTree;


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
        root.left = new TreeNode(1);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.left = new TreeNode(4);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root ==null) {
            return true;
        }
        boolean bo = isSymmetric(root.left, root.right);

        return bo;
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;                 //运用框架的核心是这几行代码一定要把情况考虑全
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;


        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
