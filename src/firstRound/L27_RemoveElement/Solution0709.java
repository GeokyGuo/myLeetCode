package firstRound.L27_RemoveElement;

import java.util.Arrays;

public class Solution0709 {
    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int re = removeElement(a, 3);
        System.out.println(re);
        System.out.println(Arrays.toString(a));
    }

    public static int removeElement(int[] nums, int val) {
        int newi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val) {
                nums[newi++] = nums[i];
            }
        }
        return newi;
    }
}
