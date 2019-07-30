package L108_ConvertSortedArraytoBinarySearchTree;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

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
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        TreeNode head = new TreeNode(nums[mid]);

        sortedArrayToBST(nums, head, left, mid, right);
        return head;
    }

    static void sortedArrayToBST(int[] nums, TreeNode root, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        if (left != mid) {
            int lmid = left + (mid - 1 - left) / 2;
            root.left = new TreeNode(nums[lmid]);
            sortedArrayToBST(nums, root.left, left, lmid, mid - 1);
        }

        int rmid = mid + 1 + (right - mid - 1) / 2;
        root.right = new TreeNode(nums[rmid]);
        sortedArrayToBST(nums, root.right, mid + 1, rmid, right);

        return;
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


        for (List<Integer> in : stack) {
            lists.add(in);
        }
        return lists;
    }
}

