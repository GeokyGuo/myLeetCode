package secondRound.Week5.L第12课_动态规划;

import java.util.Arrays;

public class L322_Coin_Change {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        //状态 dp i 是凑i元需要的最小次数
        //状态转移方程  dp i = math.min（dp i- coin1 ， dp i-coin2 。。。。） + 1

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        //要凑的总额，要大于钱币的分量， 中间值 要合法，凑不成的话设置为 -2
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                if(i < coin) continue;
                if(dp[i - coin] == amount + 1) continue;
                dp[i] = Math.min(dp[i], dp[i -coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ?  -1 : dp[amount] ;
    }

}
//啥时背包问题