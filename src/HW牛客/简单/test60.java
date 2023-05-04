package HW牛客.简单;

import java.util.Scanner;

public class test60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = 1; i < n; i++) {
            if (!isValidSu(i)) continue;

            int sub = n - i;
            if (!isValidSu(sub)) continue;


            int target = Math.abs(sub - i);
            if (target < min) {
                min = target;
                res = new int[]{i, sub};
            }

        }
        System.out.println(res[0]);
        System.out.println(res[1]);


    }


    static boolean isValidSu(Integer x) {
        if (x == 1 || x == 2) return true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
