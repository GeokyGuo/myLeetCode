package L112_PathSum;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0919 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
//
//        root.right.left = null;
//        root.right.right = null;
//
//
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);


        System.out.println(hasPathSum(root, 3));

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }

        boolean left = hasPathSum(root.left, sum - root.val);

        boolean right = hasPathSum(root.right, sum - root.val);

        return left || right;
    }
}
