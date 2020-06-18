package firstRound.L107_BinaryTreeLevelOrderTraversal2;


import util.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(3);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.left = new TreeNode(4);

        List<List<Integer>> lists = levelOrderBottom(root);

        System.out.println(lists.toString());
//        for (List<Integer> list : lists) {
//            System.out.println(list.toString());
//        }


    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;

        queue.add(root);
        List<Integer> list;
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            stack.add(list);
        }
        List<List<Integer>> lists = new ArrayList<>();

        while (!stack.isEmpty()) {
            List<Integer> in = stack.pop();
            lists.add(in);
        }
        return lists;
    }
}
