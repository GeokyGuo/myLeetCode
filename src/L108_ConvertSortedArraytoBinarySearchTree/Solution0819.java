package L108_ConvertSortedArraytoBinarySearchTree;


import util.TreeNode;

import java.util.*;

import static L107_BinaryTreeLevelOrderTraversal2.Solution.levelOrderBottom;


public class Solution0819 {

    public static void main(String[] args) {

//        int[] re = new int[]{-10, -3, 0, 5, 9};
        int[] re = new int[]{1};
        TreeNode head = sortedArrayToBST(re);
        List<List<Integer>> lists = levelOrderBottom(head);

        System.out.println(lists.toString());

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0;
        int right = nums.length;
        TreeNode root = null;
        sortedArrayToBST(nums, root, left, right);

        return root;
    }

    static TreeNode sortedArrayToBST(int[] nums, TreeNode root, int left, int right) {
        if (left == right || left < right) {

            return null;
        }

        int mid = (left + right) >>> 1;
        root = new TreeNode(nums[mid]);
//        root.val = nums[mid];

        sortedArrayToBST(nums, root.left, left, mid);
        sortedArrayToBST(nums, root.right, mid + 1, right);
        return root;
    }
}

