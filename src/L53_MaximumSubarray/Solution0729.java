package L53_MaximumSubarray;

import java.util.Arrays;

public class Solution0729 {
    public static void main(String[] args) {
        int[] nums = {3, -80, -2, -2, 1, 2, -60, 4, 5};
        int re = maxSubArray(nums);
        System.out.println(re);

    }

    /**
     * 还有一种分治法？ 有空研究一下
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int end = nums[0];
        int sum = nums[0];

        int i = 1;
        while (i < nums.length) {
            if (end > 0) {
                end = end + nums[i];
            } else {
                end = nums[i];
            }
            i++;
            if (end > sum) {
                sum = end;
            }
        }

        return sum;
    }
}