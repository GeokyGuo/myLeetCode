package HW牛客.简单;

import java.util.Arrays;
import java.util.Scanner;

public class test58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
//        (e1, e2) -> e1 - e2
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }
}
