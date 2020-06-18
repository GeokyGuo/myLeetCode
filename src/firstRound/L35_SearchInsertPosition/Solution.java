package firstRound.L35_SearchInsertPosition;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {};
        int x = 7;
        int re = searchInsert(arr, x);
        System.out.println(re);
    }

    public static int searchInsert(int[] nums, int target) {
//        if (nums.length == 0) {
//            return 0;
//        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return i;

    }
}
