package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

public class L98_Validate_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;//我只能把不符合条件的找出来，当前符合条件的 要下一步继续验证
        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);//必须把 左右都写全，，比如 左子树的右子树， 就必须既要有上界也要有下界
    }

    //还有一种方法是  中序遍历 是升序排列
}
