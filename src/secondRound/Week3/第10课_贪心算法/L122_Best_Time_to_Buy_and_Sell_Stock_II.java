package secondRound.Week3.第10课_贪心算法;

public class L122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int prof = 0;
        for(int i = 1; i < prices.length; i++){
            int sub = prices[i] - prices[i - 1];
            prof +=  sub > 0 ?  sub : 0;
        }
        return prof;
    }
}


//差分的思想
//借助 「差分」 这个概念，可以证明 「贪心算法」 的有效性。贪心算法是选择那些所有差分（严格）大于 0 的数，把它们相加即可。