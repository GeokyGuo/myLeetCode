package secondRound.Week2.第06课_树_二叉树_二叉搜索树;

import java.util.*;

public class L94_Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List reList = inorderTraversal2(root);
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

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            p = temp.right;

        }
        return list;
    }

    //复习
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.offerFirst(p);
                p = p.left;
            }
            TreeNode temp = stack.pollFirst();
            list.add(temp.val);
            p = temp.right;
        }

        return list;
    }

    //94 其他解法
    public List<Integer> inorderTraversal(util.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        util.TreeNode cur = root;
        Deque<util.TreeNode> stack = new ArrayDeque<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                util.TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }
        return res;
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
