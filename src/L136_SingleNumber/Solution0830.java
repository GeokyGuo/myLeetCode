package L136_SingleNumber;

import java.util.HashSet;

public class Solution0830 {
    public static void main(String[] args) {
        int[] a = { 0,0,2};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        int re = 0;
        int i = 0;
        while (i < nums.length) {
            re = re ^ nums[i];
            i++;
        }
        return re;
    }
}
