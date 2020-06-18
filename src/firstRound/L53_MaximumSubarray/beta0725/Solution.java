package firstRound.L53_MaximumSubarray.beta0725;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, -6, -2, -2, 1, 2, 3, 4, 5};

        HashMap m = maxSubArray(nums);
        System.out.println(m.toString());

        int[] d = maxSubArray0(nums);
        System.out.println(Arrays.toString(d));

        System.out.println(Arrays.toString(maxSubArray5(nums)));
    }

    public static HashMap maxSubArray(int[] nums) {
        int[] d = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();


        d[0] = nums[0];
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (d[i - 1] + nums[i] > nums[i]) {
                d[i] = d[i - 1] + nums[i];
                map.put(i, pre);
            } else {
                d[i] = nums[i];
                pre = i;
                map.put(i, pre);
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < d.length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        map.put(max, null);

        return map;
    }



    public static int[] maxSubArray0(int[] nums) {
        int[] d = new int[nums.length];

        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (d[i - 1] + nums[i] > nums[i]) {
                d[i] = d[i - 1] + nums[i];
            } else {
                d[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < d.length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        return d;
    }


    public static int[] maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int sum = nums[0];
        int remax = nums[0];
        int pre = 0;
        int last = 0;

        int flag = 0;

        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
                flag = 1;
            }

            if (sum > remax) {
                remax = sum;
                if (flag == 1) {
                    pre = i;
                    flag = 0;
                }
                last = i;
            }
        }
        return new int[]{pre, last};
    }

    public static int[] maxSubArray5(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int sum = nums[0];
        int remax = nums[0];
        int pre = 0;
        int last = 0;
        int rpre = 0;
        int rlast = 0;

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum = sum + nums[i];
                last = i;
            } else {
                sum = nums[i];
                pre = i;
                last = i;
            }

            if (sum > remax) {
                remax = sum;
                rpre = pre;
                rlast = last;
            }
        }
        return new int[]{rpre, rlast};
    }


}
