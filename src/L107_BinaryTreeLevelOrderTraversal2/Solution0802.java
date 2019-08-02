package L107_BinaryTreeLevelOrderTraversal2;


import util.TreeNode;

import java.util.*;

public class Solution0802 {

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
        ArrayList<List<Integer>> re = new ArrayList<>();

        levelOrderBottom(root, 0, re);
        Collections.reverse(re);
        return re;
    }

    private static void levelOrderBottom(TreeNode root, int i, List<List<Integer>> re) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> arr;
        if (i >= re.size()) {
            arr = new ArrayList<>();
            re.add(arr);
        } else {
            arr = (ArrayList<Integer>) re.get(i);
        }
        arr.add(root.val);

        levelOrderBottom(root.left, i + 1, re);
        levelOrderBottom(root.right, i + 1, re);
    }

    /**
     * 答案中这样很巧妙，可以考虑一下
     *     // 当前层数还没有元素，先 new 一个空的列表
     *     if (ans.size() <= level) {
     *         ans.add(0, new ArrayList<>());
     *     }
     *     // 当前值加入
     *     ans.get(ans.size() - 1 - level).add(root.val);
     * */
}
