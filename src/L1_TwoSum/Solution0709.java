package L1_TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].*/

public class Solution0709 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7, 9};
        int target = 14;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target-nums[i])) {
                map.put(nums[i],i);
            }else{
                return new int[]{map.get(target-nums[i]),i};
            }

        }
        return null;
    }
}

