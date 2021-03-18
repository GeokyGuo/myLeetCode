package secondRound.Week5.第12课_动态规划.股票系列;

public class L188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        // dp[i][j] 在i天 状态为 j 时 的最大收益 j = 0 ----2*k -1
        //
        if(prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        for(int j = 0; j < 2 * k + 1; j++){
            dp[0][j] = j % 2 == 1 ? - prices[0] : 0;
        }

        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j < 2 * k + 1; j++){
                if(j % 2 == 1){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]) ;
                }
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
