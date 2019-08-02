package L136_SingleNumber;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 2, 5, 1, 1};
        System.out.println(singleNumber1(a));
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int re = -1;

        for (Integer integer : set) {
            re = integer;
        }
        return re;
    }

    /**
     * 异或法
     */
    public static int singleNumber1(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = sum ^ nums[i];

        }

        return sum;
    }
}
