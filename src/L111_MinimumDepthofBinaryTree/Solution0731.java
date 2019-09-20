package L111_MinimumDepthofBinaryTree;

import util.TreeNode;

public class Solution0731 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
//
//
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//
//
//        root.right = new TreeNode(2);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);


        System.out.println(minDepth(root));
    }

    /**
     * 写写递归法
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right ? left + 1 : right + 1;
    }

}
//null 放到队列中占不占位？？？答案是占位