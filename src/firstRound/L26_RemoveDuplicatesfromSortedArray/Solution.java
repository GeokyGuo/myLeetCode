package firstRound.L26_RemoveDuplicatesfromSortedArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int re = removeDuplicates(a);
        System.out.println(re);
        System.out.println(Arrays.toString(a));

    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }

        }
        return index + 1;
    }
}
