package secondRound.Week2.第06课_树_二叉树_二叉搜索树;

import java.util.*;

public class L94_Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List reList = inorderTraversal(root);
        System.out.println(Arrays.toString(reList.toArray()));


    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list, root);
        return list;
    }

    public static void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        stack.push(p);
        p = p.left;

        while (!stack.isEmpty()) {
            while (p != null) {
                stack.push(root);
                p = p.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            stack.push(p.right);
        }


        return null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

}
