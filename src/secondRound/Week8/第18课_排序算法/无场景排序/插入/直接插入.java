package secondRound.Week8.第18课_排序算法.无场景排序.插入;

import java.util.Arrays;

public class 直接插入 {


    public static void main(String[] args) {
        int[] num = {5,9,4,1,6,7};
        insertSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void insertSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            if (num[i] < num[i - 1]) {
                int temp = num[i];
                int j = i - 1;
                while (j >= 0 && temp < num[j]) {
                    num[j + 1] = num[j];
                    j--;
                }
                num[j + 1] = temp;
            }
        }
    }
}