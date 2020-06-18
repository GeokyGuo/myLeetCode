package firstRound.L70_ClimbingStairs;

public class Solution0828 {
    public static void main(String[] args) {
        int n = 6;
        int re = climbStairs(n);
        System.out.println(re);
    }


    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int n1 = 1;
        int n2 = 2;
        int i = 3;
        int re = 0;
        while (i <= n) {
            re = n1 + n2;
            n1 = n2;
            n2 = re;
            i++;
        }
        return re;
    }
}
