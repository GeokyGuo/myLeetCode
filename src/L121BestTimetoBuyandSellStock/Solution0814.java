package L121BestTimetoBuyandSellStock;

import java.util.Arrays;

public class Solution0814 {
    public static void main(String[] args) {
        int[] prices = {3, 5, -2, -2, 1, 2, -60, 4, 5};
        int[] remax = maxProfit(prices);
        System.out.println(Arrays.toString(remax));
    }


    public static int[] maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return new int[]{0};
        }

        int[] d = new int[prices.length];
        int maxre = 0;
        d[0] = prices[0];

        int i = 1;
        while (i < prices.length) {
            if (prices[i - 1] < d[i - 1]) {
                d[i] = prices[i - 1];
            } else {
                d[i] = d[i - 1];
            }
            i++;
        }
        i = 0;
        while (i < d.length) {
            int sub = prices[i] - d[i];
            if (sub > maxre) {
                maxre = sub;
            }
            i++;
        }
        d[0] = maxre;
        return d;
    }
}
