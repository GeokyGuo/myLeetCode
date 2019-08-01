package L112_PathSum;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
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


        System.out.println(hasPathSum2(root, 3));

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode head = new TreeNode(root.val);
        queue.add(root);
        queue.add(head);

        TreeNode cur;
        TreeNode curdul;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curdul = queue.poll();

            if (cur.left != null) {
                curdul.left = new TreeNode(curdul.val + cur.left.val);
                queue.add(cur.left);
                queue.add(curdul.left);
            }
            if (cur.right != null) {
                curdul.right = new TreeNode(curdul.val + cur.right.val);
                queue.add(cur.right);
                queue.add(curdul.right);
            }

        }

        return transTree(head, sum);
    }

    static boolean transTree(TreeNode root, int sum) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur.left == null && cur.right == null && cur.val == sum) return true;

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        return false;
    }

    /**
     * 递归法
     */
    public static boolean hasPathSum2(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        int sub = sum - root.val;
        if (root.left == null && root.right == null && sub == 0) {
            return true;
        }

        return hasPathSum2(root.left, sub) || hasPathSum2(root.right, sub);
    }
}
