package L35_SearchInsertPosition;

public class Solution0719 {
    public static void main(String[] args) {
        int[] arr = {};
        int x = 7;
        int re = searchInsert(arr, x);
        System.out.println(re);
    }

    public static int searchInsert1(int[] nums, int target) {//还是没有想起来用二分查找
        int i = 0;
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        return i;
    }


    public static int searchInsert(int[] nums, int target) {//还是没有想起来用二分查找
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;

            } else {
                right = mid;
            }
        }
        return left;
    }
}
