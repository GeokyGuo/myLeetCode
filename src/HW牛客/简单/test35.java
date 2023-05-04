package HW牛客.简单;

import java.util.Scanner;

public class test35 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] res = new int[n][n];

        res[0][0] = 1;
        int step = 1;
        for (int i = 1; i < n; i++) {
            res[i][0] = res[i - 1][0] + step;
            step++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                res[i][j] = res[i + j][0] + j;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}

//利用对角线下标 和相等 或者差相等 todo

//与53题类似，也可以用动态规划的思想