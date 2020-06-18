package firstRound.L27_RemoveElement;

import java.util.Arrays;

public class Solution0920 {
    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int re = removeElement(a, 3);
        System.out.println(re);
        System.out.println(Arrays.toString(a));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
            i++;

        }

        return k;
    }
}
