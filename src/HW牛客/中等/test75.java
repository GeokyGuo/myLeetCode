package HW牛客.中等;

import java.util.Scanner;

public class test75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        String newStr1 = " " + str1;
        String newStr2 = " " + str2;

        //dp[i][j]  i newstr1 i结尾的字符， jnewstr2 j结尾的字符，  这个字符串 作为公共子串的长度
        //状态转移  newstr1[i] == newstr2[j]  dp[i][j]  = dp[i-1][j-1] +1
        //状态转移  newstr1[i] != newstr2[j]  dp[i][j]  = dp[i-1][j-1]

        int[][] dp = new int[newStr2.length()][newStr1.length()];

        int res = 0;
        for (int j = 1; j < newStr1.length(); j++) {
            for (int i = 1; i < newStr2.length(); i++) {
                if (newStr1.charAt(j) == newStr2.charAt(i)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(res);


    }

}


//todo  一定想清楚  dp[i][j]  是 i ，j 下标作为公共子串时的 长度，
// 还是所有 i，j结尾的字符串的最大公共长度 （这个理解方式，好像可以用来求最大公共子序列，待验证）