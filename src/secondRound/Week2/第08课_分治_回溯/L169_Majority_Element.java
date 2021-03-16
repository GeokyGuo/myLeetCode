package secondRound.Week2.第08课_分治_回溯;

public class L169_Majority_Element {
    public static void main(String[] args) {
        int[] a = {3,2,3};
        int re = majorityElement2(a);
        System.out.println(re);
    }

    //可以学习一下投票算法

    //分治法
    public int majorityElement(int[] nums) {
        int re = majortyElement(nums, 0, nums.length - 1);
        return re;
    }

    public int majortyElement(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (right - left) / 2 + left;
        int leftNum = majortyElement(nums, left, mid);
        int rightNum = majortyElement(nums, mid + 1, right);
        if (leftNum == rightNum) return leftNum;

        int r1 = coutNum(nums, left, mid, leftNum);
        int r2 = coutNum(nums, mid + 1, right, rightNum);

        return r1 > r2 ? leftNum : rightNum;
    }

    int coutNum(int[] nums, int left, int right, int target) {
        int cout = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                cout++;
            }
        }
        return cout;
    }


    //本题用投票算法是最佳的算法
    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static int majorityElement2(int[] nums) {
        int count = 1;
        int candidate = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
