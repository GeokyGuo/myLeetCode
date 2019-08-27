package L107_BinaryTreeLevelOrderTraversal2;


import util.TreeNode;

import java.util.*;

public class Solution0827 {

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
        LinkedList wlist = new LinkedList();
        if (root == null) {
            return wlist;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> nlist = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                nlist.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            wlist.addFirst(nlist);

        }

        return wlist;
    }
}
