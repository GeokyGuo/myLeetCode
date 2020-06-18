package firstRound.L122_BestTimetoBuyandSellStockII;

public class Solution {
    public static void main(String[] args) {
        int[] in = {7, 1, 5, 3, 6, 4};
        int re = maxProfit(in);
        System.out.println(re);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int sub = prices[i + 1] - prices[i];
            if (sub > 0) {
                sum += sub;
            }
        }
        return sum;
    }
}
