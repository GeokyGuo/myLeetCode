package firstRound.L104_MaximumDepthofBinaryTree;


import util.TreeNode;

public class Solution0729 {

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

    public static int maxDepth(TreeNode root) {    //这种 把想要携带的参数 也用递归来表示，更加简单
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
