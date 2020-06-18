package firstRound.L26_RemoveDuplicatesfromSortedArray;

import java.util.Arrays;

public class Solution0827 {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int re = removeDuplicates(a);
        System.out.println(re);
        System.out.println(Arrays.toString(a));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right++];
            } else {
                right++;
            }
        }
        return left + 1;
    }
}
