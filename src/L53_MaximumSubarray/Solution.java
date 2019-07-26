package L53_MaximumSubarray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, -80, -2, -2, 1, 2, -60, 4, 5};
        int[] re = maxSubArray(nums);
        System.out.println(Arrays.toString(re));

    }

/**
 * 还有一种分治法？ 有空研究一下
 * */
    public static int[] maxSubArray(int[] nums) {
        int end = nums[0];
        int remax = nums[0];

        int pre = 0;
        int rpre = 0;
        int rlast = 0;


        for (int i = 1; i < nums.length; i++) {
            if (end > 0) {
                end = end + nums[i];
            } else {
                end = nums[i];
                pre = i;
            }

            if (end > remax) {
                remax = end;
                rpre = pre;
                rlast = i;
            }
        }
        return new int[]{rpre, rlast, remax};
    }
}