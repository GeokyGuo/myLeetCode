package secondRound.Week5.第12课_动态规划;

public class L91_Decode_Ways {
    public static void main(String[] args) {
        String s = "1201234";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        //定义状态和子问题，dpi 是以i-1结尾的字符串的 可以编码的数量

        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int a = Integer.valueOf(s.charAt(0));
        dp[1] = a == 0 ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            int temp = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if ((temp > 20 && temp % 10 == 0) || temp == 0)
                dp[i] = 0;
            else if (temp == 20 || temp == 10)
                dp[i] = dp[i - 2];
            else if ((temp >= 11 & temp <= 19) || (temp >= 21 && temp <= 26))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[dp.length - 1];
    }

}

//两位数组合起来后
//不可编码  00  30  40 50 60 70 80 90
//编成两种  [11 --- 19] ， [21 --- 26]
//只能编一种,分两种情况
//                                          10 20          dp[i] = dp[i - 2]   必须回退两格
//  [01,09] [29,29] [31,39] [41,49] ......[91,99]          dp[i] = dp[i - 1]