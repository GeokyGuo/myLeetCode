package secondRound.Week8.第18课_排序算法.无场景排序.插入;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] num = {5, 97, 9, 8, 4, 1, 6, 7};
        shellSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void shellSort(int[] nums) {
        for (int dk = nums.length / 2; dk >= 1; dk /= 2) {
            for (int i = dk; i < nums.length; i++) {
                if (nums[i - dk] > nums[i]) {
                    int target = nums[i];
                    int j = i - dk;
                    while (j >= 0 && nums[j] > target) {
                        nums[j + dk] = nums[j];
                        j -= dk;
                    }
                    nums[j + dk] = target;
                }
            }
        }
    }
}
