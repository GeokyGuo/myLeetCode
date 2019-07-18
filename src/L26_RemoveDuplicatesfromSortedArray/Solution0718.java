package L26_RemoveDuplicatesfromSortedArray;

import java.util.Arrays;

public class Solution0718 {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // int[] a = {1};
        int re = removeDuplicates(a);
        System.out.println(re);
        System.out.println(Arrays.toString(a));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int newi = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[newi]) {
                nums[++newi] = nums[i++];


            } else {
                i++;
            }
        }


        return newi + 1;
    }
}
