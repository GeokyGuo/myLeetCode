package firstRound.L35_SearchInsertPosition;

public class Solution0824 {
    public static void main(String[] args) {
        int[] arr = {1,2,7,9,10,16};
        int x = 17;
        int re = searchInsert(arr, x);
        System.out.println(re);
    }

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length ;

        while (left < right) {
            int mid = left + right  >>> 1; //daiding

            if (nums[mid] < target) {
                left   = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
