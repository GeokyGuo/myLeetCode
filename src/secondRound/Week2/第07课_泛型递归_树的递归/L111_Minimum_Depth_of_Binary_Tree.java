package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

public class L111_Minimum_Depth_of_Binary_Tree {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left==0||right==0) return left + right + 1;  //之所有要加这一步，是因为 12这中情况时，   1的右子树为空，会返回0.而0不能参与 最小的比较，因为，一条路为0，要接着走另一条路
        return Math.min(left, right) + 1;
    }
//如果不加这一步判断  则，1   返回1   12null  树还是返回1
// leetcode 使用 完全二叉树的顺序，
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth1(root.right) + 1;
        }
        if (root.left != null && root.right == null) {   //之所有要加这一步，是因为 12这中情况时，   1的右子树为空，会返回0.而0不能参与 最小的比较，因为，一条路为0，要接着走另一条路
            return minDepth1(root.left) + 1;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        return left < right ? left + 1 : right + 1;
    }
}
