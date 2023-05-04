package HW牛客.简单;

import java.util.Scanner;

public class test37 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

    }
}

//无从下手的题目要   手动去写几个递推的过程，可能规律就出来了  todo