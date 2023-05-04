package HW牛客.简单;

import java.util.Scanner;

public class test53 {//未ac

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] res = new int[n][];

        res[0] = new int[1];
        res[0][0] = 1;

        for (int i = 1; i < res.length; i++) {
            res[i] = new int[2 * i + 1];
            for (int j = 0; j < 2 * i + 1; j++) {
                int length = res[i - 1].length;
                int first = 0;
                int sec = 0;
                int third = 0;

                third = j < length ? res[i - 1][j] : 0;
                sec = ((j - 1) < length && j - 1 >= 0) ? res[i - 1][j - 1] : 0;
                first = ((j - 2) < length && j - 2 >= 0) ? res[i - 1][j - 2] : 0;

                res[i][j] = first + sec + third;
            }
        }


        for (int j = 0; j < 2 * n - 1; j++) {
            if (res[n - 1][j] % 2 == 0) {
                System.out.println(j + 1);
                return;
            }
        }
        System.out.println(-1);

    }
}

//todo  二维数组 实例化时，第二位可以先不指定大小
//本题的空间复杂度超出，单单优化不行，要另辟蹊径