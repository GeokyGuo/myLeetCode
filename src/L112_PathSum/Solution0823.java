package L112_PathSum;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0823 {
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


    /**
     * 递归法
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int sub = sum - root.val;
        if (root.left == null && root.right == null && sub == 0) {
            return true;
        }
        return hasPathSum(root.left, sub) || hasPathSum(root.right, sub);
    }
}
