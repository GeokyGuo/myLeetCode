package secondRound.Week8.第18课_排序算法.无场景排序.插入;

import java.util.Arrays;

public class 折半插入 {
    public static void main(String[] args) {
        int[] num = {5, 97, 9, 8, 4, 1, 6, 7};
        insertSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void insertSort(int[] nums) {
//        找一个数，恰好比target大


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {


                int left = 0;
                int right = i - 1;
                int target = nums[i];

                while (left < right) {
                    int mid = left + (right - left) / 2;

                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                for (int j = i - 1; j >= left; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[left] = target;

            }
        }

    }

}
