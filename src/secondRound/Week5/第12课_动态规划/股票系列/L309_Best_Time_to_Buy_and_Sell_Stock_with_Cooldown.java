package secondRound.Week5.第12课_动态规划.股票系列;

public class L309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        //定义状态  dij  i天时 持股状态j 时的最大收益， j = 0 正常不持股 j =1 持股 j = 2 卖出不持股
        //画出状态机
        //写状态转移方程
        // d[i][0] = Max(d[i-1][0],d[i-1][2]);
        // d[i][1] = Max(d[i-1][1],d[i-1][0] - price[1]);
        // d[i][2] = d[i-1][1] + price[i];

        int[][] dp = new int[prices.length][3];
//        dp[0][0] = 0;
        dp[0][1] = - prices[0];
//        dp[0][2] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0],dp[prices.length - 1][2]);
    }
}
