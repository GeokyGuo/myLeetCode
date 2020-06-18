package firstRound.L121BestTimetoBuyandSellStock;

import java.util.Arrays;

public class Solution0729 {
    public static void main(String[] args) {
        int[] prices = {3, 5, -2, -2, 1, 2, -60, 4, 5};
        int re = maxProfit(prices);
        System.out.println(re);
    }


    /**
     * 还有一种是差分求和的思想
     */

    //非精简的方法
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int end = prices[0];
        int maxprofit = 0;

        int i = 1;
        while (i < prices.length) {
            if (prices[i - 1] < end) {
                end = prices[i - 1];

            }
            int sub = prices[i] - end;
            if (sub > maxprofit) {
                maxprofit = sub;
            }
            i++;
        }

        return maxprofit;
    }
}
