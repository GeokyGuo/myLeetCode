package firstRound.L121BestTimetoBuyandSellStock;


public class Solution0802 {
    public static void main(String[] args) {
        int[] prices = {1};
//        int[] remax = maxProfit(prices);
//        System.out.println(Arrays.toString(remax));

        int remax = maxProfit(prices);
        System.out.println(remax);

    }


    /**
     * 还有一种是差分求和的思想
     *
     * */

    //非精简的方法
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }

        int end = prices[0];//这三个好好理解一下怎么赋值 初始值，因为状态定义的是i之前的最小，所以end是起始，就是0.  而i要从1，
        int max = 0;        //max就是起始的最小利润，肯定就是0噻，不可能赔了噻
        int i = 1;          //


        while (i < prices.length) {
            if (prices[i] < end) {
                end = prices[i];

            }

            int sub = prices[i] - end;
            if (sub > max) {
                max = sub;
            }
            i++;
        }

        return max;
    }



}
