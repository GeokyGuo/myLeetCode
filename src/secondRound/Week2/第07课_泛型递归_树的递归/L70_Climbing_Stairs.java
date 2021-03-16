package secondRound.Week2.第07课_泛型递归_树的递归;

import java.util.ArrayList;
import java.util.List;

public class L70_Climbing_Stairs {
    public static void main(String[] args) {
        int n = 8;
        int re = climbStairs(n);
        int re1 = climbStairs(n);
        System.out.println(re);
        System.out.println(re1);

    }

    //优化的动态规划
    public static int climbStairs(int n) {
        if (n < 3) return n;
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }


    //优化的递归方案
    public static int climbStairs2(int n) {
        Integer[] cache = new Integer[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        int temp = climbStairs2(cache, n);
        return temp;
    }

    public static int climbStairs2(Integer[] cache, int n) {
        if (cache[n] != null) return n;
        cache[n] = climbStairs2(cache, n - 1) + climbStairs2(cache, n - 2);
        return cache[n];
    }


}
