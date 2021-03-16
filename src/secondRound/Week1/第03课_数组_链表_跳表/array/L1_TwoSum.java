package secondRound.Week1.第03课_数组_链表_跳表.array;

import java.util.Arrays;
import java.util.HashMap;

public class L1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int ta = 7;
        int[] re = twoSum1(nums, ta);
        System.out.println(Arrays.toString(re));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        HashMap map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.get(sub) != null) {
                re[0] = (int) map.get(sub);
                re[1] = i;
                return re;
            } else {
                map.put(nums[i], i);
            }
        }
        return re;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] re = new int[2];
        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; ) {
            //如果 双指针相加 大于目标，则右指针左移  如果小于目标则 左指针右移   如果相等则返回
            if (nums[i] + nums[j] > target) j--;
            if (nums[i] + nums[j] < target) i++;
            if (nums[i] + nums[j] == target) return new int[]{i, j};
        }
        return re;
    }

    //复习
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            } else {
                map.put(nums[i], i);
                i++;
            }
        }
        return new int[0];
    }

}

//map.get(sub) != null 可以写成 map.containsKey(complement)
//双指针的方法  不能判断下标



