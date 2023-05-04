package HW牛客.中等;

import java.util.Arrays;
import java.util.Scanner;

public class test45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int[] count = new int[26];

            String str = in.nextLine();
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            Arrays.sort(count);

            int res = 0;
            for (int j = count.length - 1; j >= 0; j--) {
                res = res + count[j] * (j + 1);
            }
            System.out.println(res);
        }
    }
}
