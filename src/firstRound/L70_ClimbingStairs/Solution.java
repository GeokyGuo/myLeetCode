package firstRound.L70_ClimbingStairs;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int re = climbStairs(n);
        System.out.println(re);
    }


    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
// 不用判断 n==2 的情况，应为arr最少是3个长度，那么只有n==1时 不满足长度为3
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];

        }
        return arr[n];
    }
}
