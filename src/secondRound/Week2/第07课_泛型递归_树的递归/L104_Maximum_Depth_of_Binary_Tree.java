package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

public class L104_Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {

    }


    //自上而下，max相当于全局变量
    public int maxDepth(TreeNode root) {
        return maxDepth(0, root);
    }

    int maxDepth(int max, TreeNode root) {
        if (root == null) {
            return max;
        }
        max++;
        int left = maxDepth(max, root.left);
        int right = maxDepth(max, root.right);

        return left > right ? left : right;
    }

    //参考答案，自下而上，更符合递归的思想
    public int maxDepth2(TreeNode root) {
        if (root==null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return Math.max(left, right) + 1;
    }

}
