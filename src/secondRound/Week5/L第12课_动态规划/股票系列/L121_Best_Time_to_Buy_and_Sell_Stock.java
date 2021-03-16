package secondRound.Week5.L第12课_动态规划.股票系列;

public class L121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        //子问题，子状态时  dpi  在第i天卖出，所能获取的最大利润
        //转移方程  n i - ni-1 > 0  dp[i] = d i-1 + sub
        //          n i - ni-1 < 0  dp[i] = d i-1 - sub
        int max = 0;
        int dp[] = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i - 1];
            dp[i] = dp[i - 1] + sub;
            if (dp[i] < 0) dp[i] = 0;
            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }



    public int maxProfit3(int[] prices) {
        //子问题，子状态的定义， dij 代表 i天  持股状态j时  的最大利益 j=0 不持股，j=1持股
        //转移方程 di0 =max(d[i][0], d[i-1][1] + price[i])
        //di1 = max(d[i-1][1] , -price[i])

        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];

    }
}

//方法一， 动态规划求每个元素之前的最大或者最小元素  <--- 转化 --->  方法二 动态贵规划转化成差分， 求最大连续序列
//方法三用股票题目的通解


//方法一定义动态规划状态的方法：
//子问题，子状态是  di 是 i之前的最小元素的值，
//状态转移方程  di = hi-1 < d(i-1)  ? h(i-1) : d(i -1)