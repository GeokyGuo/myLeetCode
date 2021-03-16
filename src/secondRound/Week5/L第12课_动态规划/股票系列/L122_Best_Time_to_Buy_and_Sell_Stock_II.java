package secondRound.Week5.L第12课_动态规划.股票系列;

public class L122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {


        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            int sub = prices[i] - prices[i -1];
            if(sub > 0) sum += sub;
        }
        return sum;
    }

    //股票的通解
    public int maxProfit2(int[] prices) {
        //子问题，子状态的定义， dij 代表 i天  持股状态j时  的最大利益 j=0 不持股，j=1持股
        //转移方程 di0 =max(d[i][0], d[i-1][1] + price[i])
        //di1 = max(d[i-1][1] , -price[i])

        if(prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}
