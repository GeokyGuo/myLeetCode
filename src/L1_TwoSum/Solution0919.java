package L1_TwoSum;

import javax.print.attribute.HashAttributeSet;
import java.util.Arrays;
import java.util.HashMap;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].*/

public class Solution0919 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7, 9};
        int target = 3;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap();

            int i = 0;
            while (i < nums.length) {
                int sub = target - nums[i];
                if (map.containsKey(sub)) {
                    return new int[]{map.get(sub), i};
                } else {
                    map.put(nums[i], i);
                }


                i++;
            }

            return new int[]{};
    }

}

