package secondRound.Week5.第12课_动态规划.股票系列;

public class L123_Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {


        //要理解max的含义 dp中表示的是,【如果，假设】买两次的状态，并不代表一定就会这样做，更多的是一种假设，比如第 i天 买1的情况是啥样? 第i天卖2的情况是啥样?（是会出现新的最大利润，还是会【延续】之前的某一天的最大利润?）
        //初始版本就应该 i天 j的所有状态 都是由 i-1 天的状态推出， 也应该这么去写，唯一有点不好理解的是初始化时，买2，即j=3，为啥是-prices？
        //想要升级就是，i天  j的所有状态 都可以由 i天当天的状态推出， 对应的初始化很好想
            // 为啥可以这么做，就要深刻理解max的含义，
            // 买入 dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i]);
            // 卖出 d[i][2] = max(d[i-1][2],d[i][1] + price[i]),  问题就是用了当天的d[i][1] 后，会啥会对，
            // d[i][1] 取dp[i - 1][1]，那正好，符合取前一天规则，d[i][1] 取 dp[i][0] - prices[i] 意思是 当天买入，再卖出，这种情况的状态，必然小于等于，之前 已经有过交易的某个dp[k][2]的利润，因此也不影响结果

        if(prices.length == 0) return 0;
        int[][] dp = new int[prices.length][5];

        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        dp[0][3] = - prices[0];
        dp[0][4] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];


//        if(prices.length == 0) return 0;
//        int[][] dp = new int[prices.length][5];
//
//        dp[0][0] = 0;
//        dp[0][1] = - prices[0];
//        dp[0][2] = 0;
//        dp[0][3] = - prices[0];
//        dp[0][4] = 0;
//        for(int i = 1; i < prices.length; i++){
//            dp[i][0] = dp[i][0];
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
//            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
//        }
//        return dp[prices.length - 1][4];

    }
}
