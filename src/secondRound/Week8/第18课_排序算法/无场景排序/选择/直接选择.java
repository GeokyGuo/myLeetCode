package secondRound.Week8.第18课_排序算法.无场景排序.选择;

import java.util.Arrays;

public class 直接选择 {
    public static void main(String[] args) {
        int[] num = {5, 97, 9, 8, 4, 1, 6, 7};
        selectSort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void selectSort(int[] nums){
        for(int i =0; i< nums.length-1;i++){
            int min = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
