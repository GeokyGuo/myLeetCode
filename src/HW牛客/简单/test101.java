package HW牛客.简单;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int method = in.nextInt();
        Comparator<Integer> cmp = method == 0 ? Comparator.comparingInt(o -> o) : (o1, o2) -> o2 - o1;
        Arrays.sort(arr, cmp);
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }

    }
}
