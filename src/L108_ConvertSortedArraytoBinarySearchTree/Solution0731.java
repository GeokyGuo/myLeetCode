package L108_ConvertSortedArraytoBinarySearchTree;


import java.util.*;


public class Solution0731 {

    public static void main(String[] args) {

        int[] re = new int[]{-10, -3, 0, 5, 9};
        TreeNode head = sortedArrayToBST(re);
        List<List<Integer>> lists = levelOrderBottom(head);

        System.out.println(lists.toString());

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        int left = 0;
        int right = nums.length;
        TreeNode head = sortedArrayToBST(nums, left, right);


        return head;
    }

    static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (nums.length == 0) {
            return null;
        }
        if (left == right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }



    //----------------------------------------------------------------------------------------//
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


        for (List<Integer> in : stack) {
            lists.add(in);
        }
        return lists;
    }
}

