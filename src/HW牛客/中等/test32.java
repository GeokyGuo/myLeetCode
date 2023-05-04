package HW牛客.中等;

import java.util.Arrays;
import java.util.Scanner;

public class test32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        //状态 dp[i][j]  表示以 i和j为下标, 【作为回文串】,它的长度(若i，j不是回文串,则dp[i][j] =0)todo
        //状态转移方程  当s[i] == s[j]，dp[i][j] = dp[i+1][j-1] +2

        int[][] dp = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }

        int res = 0;
        for (int j = 1; j < str.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] == 0 ? 0 : dp[i + 1][j - 1] + 2;
                    }

                    res = Math.max(res, dp[i][j]);
//                    if(res == 6){
//                        System.out.println(i + " " +j);
//                        System.out.println(str.substring(i,j+1));
//                    }
                }
            }
        }
        System.out.println(res);

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));

        }

    }
}
