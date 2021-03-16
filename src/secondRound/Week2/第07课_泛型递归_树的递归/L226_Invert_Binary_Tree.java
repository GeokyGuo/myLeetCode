package secondRound.Week2.第07课_泛型递归_树的递归;

import util.TreeNode;

public class L226_Invert_Binary_Tree {
    public static void main(String[] args) {

    }

    //自己写的，自上到下
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode temp;
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    //参考答案，自底向上，感觉更好一点
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
