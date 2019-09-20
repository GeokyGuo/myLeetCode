package L111_MinimumDepthofBinaryTree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Solution0920 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//
//        root.right.left = null;
//        root.right.right = null;
//
//
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);


        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

}
