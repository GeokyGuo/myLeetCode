package L108_ConvertSortedArraytoBinarySearchTree;


import util.TreeNode;

import java.util.*;

import static L108_ConvertSortedArraytoBinarySearchTree.Solution0731.levelOrderBottom;


public class Solution0918 {

    public static void main(String[] args) {

        int[] re = new int[]{-10, -3, 0, 5, 9};
        TreeNode head = sortedArrayToBST(re);
        List<List<Integer>> lists = levelOrderBottom(head);

        System.out.println(lists.toString());

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        int left = -1;
        int right = nums.length - 1;

        TreeNode head = sortedArrayToBST(nums, left, right);

        return head;
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {

        if (left >= right) {
            return null;
        }

        int mid = (left + right + 1) >>> 1;

        TreeNode head = new TreeNode(nums[mid]);
        head.left = sortedArrayToBST(nums, left, mid - 1);
        head.right = sortedArrayToBST(nums, mid, right);
        return head;
    }
}

