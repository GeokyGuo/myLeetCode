package firstRound.L100_SameTree;


import util.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(-1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.right = new TreeNode(-1);

        TreeNode q = new TreeNode(-1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        q.left.right = new TreeNode(0);
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {

            return isSameTree(p.right, q.right) & isSameTree(p.left, q.left);
        } else {

            return false;
        }


    }
}
