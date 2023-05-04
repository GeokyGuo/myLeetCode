package 复习一轮;

import util.TreeNode;

import java.util.*;

public class test06 {
    public static void main(String[] args) {

    }

    //144 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderdfs(res, root);


        return res;
    }

    public void preOrderdfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preOrderdfs(res, root.left);
        preOrderdfs(res, root.right);
    }

    //144 非递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }

        return res;
    }

    //94
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }
        return res;
    }

    //145
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode r = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != r) {//todo
                    cur = peek.right;
                } else {
                    TreeNode pop = stack.pop();
                    res.add(pop.val);
                    r = pop;
                }
            }
        }

        return res;
    }
}
