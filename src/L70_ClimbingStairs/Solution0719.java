package L70_ClimbingStairs;

public class Solution0719 {
    public static void main(String[] args) {
        int n = 6;
        int re = climbStairs(n);
        System.out.println(re);
    }


    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;

        int i = 2;
        while (i < n) {
            second = first + second;
            first = second - first;
            i++;
        }
        return second;
    }
}
