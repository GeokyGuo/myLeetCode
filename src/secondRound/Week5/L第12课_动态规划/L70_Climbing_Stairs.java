package secondRound.Week5.L第12课_动态规划;

public class L70_Climbing_Stairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for(int i = 2; i <= n; i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }


    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }
}
