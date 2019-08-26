package L53_MaximumSubarray;

public class Solution0826 {
    public static void main(String[] args) {
        int[] nums = {3, -80, -2, -2, 1, 2, -60, 4, 5};
        int re = maxSubArray(nums);
        System.out.println(re);

    }


    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int d = nums[0];

        int remax = d;

        int i = 1;
        while (i < nums.length) {
            if (d > 0) {
                d = d + nums[i];
            } else {
                d = nums[i];
            }

            if (d > remax) {
                remax = d;
            }
            i++;
        }

        return remax;
    }
}