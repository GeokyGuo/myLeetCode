package HW牛客.简单;

import java.util.Arrays;
import java.util.Scanner;

public class test80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arrn1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arrn1[i] = in.nextInt();
        }

        int n2 = in.nextInt();
        int[] arrn2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arrn2[i] = in.nextInt();
        }
        Arrays.sort(arrn1);
        Arrays.sort(arrn2);

        int i = 0;
        int j = 0;
        do {
            int print = arrn1[i] < arrn2[j] ? arrn1[i++] : arrn2[j++];
            System.out.print(print);
            while (i < arrn1.length && arrn1[i] == print) i++;
            while (j < arrn2.length && arrn2[j] == print) j++;


        } while (i < arrn1.length && j < arrn2.length);
        while (i < arrn1.length) {
            System.out.print(arrn1[i++]);
        }
        while (j < arrn2.length) {
            System.out.print(arrn2[j++]);
        }
    }
}


//有序、不重复 直接考虑使用treeMap todo
//数组升序合并、过滤重复元素 (很明显这是考察 TreeSet 的用法) TreeSet 的性质：有序、不重复