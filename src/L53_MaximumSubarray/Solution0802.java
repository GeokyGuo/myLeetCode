package L53_MaximumSubarray;

import java.util.Arrays;

public class Solution0802 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] re = maxSubArray(nums);
        System.out.println(Arrays.toString(re));

    }

    /**
     * 还有一种分治法？ 有空研究一下
     */
    public static int[] maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int end = nums[0];
        int remax = nums[0];

        int left = 0;
        int right = 0;

        int rleft = 0;
        int rright = 0;


        int i = 1;
        while (i < nums.length) {
            if (end > 0) {
                end = end + nums[i];
                right = i;
            } else {
                end = nums[i];
                left = i;
                right = i;
            }
            if (end > remax) {
                remax = end;
                rleft = left;
                rright = right;
            }
            i++;
        }
        return new int[]{rleft, rright, remax};
    }
}