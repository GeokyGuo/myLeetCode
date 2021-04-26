package secondRound.Week8.第18课_排序算法.无场景排序.交换;

import java.util.Arrays;

public class 冒泡 {
    public static void main(String[] args) {
        int[] num = {5, 97, 9, 8, 4, 1, 6, 7};
        bubbleSort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
//            boolean flag = false;

            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
//                    flag = true;
                }
            }
//            if(flag == false){
//                return;
//            }

        }
    }
}
