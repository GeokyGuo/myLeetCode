package HW牛客.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            List<String> longestStr = new ArrayList<>();
            findLongestSdtr(str, longestStr);
            longestStr.forEach(System.out::print);
            System.out.println("," + longestStr.get(0).length());
        }
    }

    private static void findLongestSdtr(String str, List<String> longestStr) {

        //状态 dp[i] i结尾的字符串，【作为子串】表示的数字长度  todo
        // d[i]  arr[i] != 数字  d[i] = 0 ;  d[i] = d[i-1] +1
        int[] dp = new int[str.length()];

        dp[0] = Character.isDigit(str.charAt(0)) ? 1 : 0;

        int maxLength = dp[0];
        for (int i = 1; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
                maxLength = Math.max(maxLength, dp[i]);
            } else {
                dp[i] = 0;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) {
                String substring = str.substring(i - maxLength + 1, i + 1);
                longestStr.add(substring);
            }
        }
    }
}
