package firstRound.L121BestTimetoBuyandSellStock;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {3, 5, -2, -2, 1, 2, -60, 4, 5};
        int[] remax = maxProfit(prices);
        System.out.println(Arrays.toString(remax));
    }


    /**
     * 还有一种是差分求和的思想
     *
     * */

    //非精简的方法
    public static int[] maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return null;
        }

        int[] d = new int[prices.length];//d 之前的最小值
        int[] x = new int[prices.length];// 这个最小值的下标

        d[0] = prices[0];
        x[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < d[i - 1]) {
                d[i] = prices[i - 1];
                x[i] = i - 1;
            } else {
                d[i] = d[i - 1];
                x[i] = x[i - 1];
            }

        }
        int remax = Integer.MIN_VALUE;
        int[] re = new int[3];
        for (int i = 0; i < d.length; i++) {
            int sub = prices[i] - d[i];
            if (sub > remax) {
                remax = sub;
                re[0] = x[i];
                re[1] = i;
                re[2] = remax;

            }
        }
        return re;
    }


   // 精简的方法
    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }

        int end = prices[0];
        int remax = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < end) {
                end = prices[i - 1];
            }
            int sub = prices[i] - end;
            if(sub>remax){
                remax = sub;
            }


        }
        return remax;
    }
}
