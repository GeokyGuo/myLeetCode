package secondRound.Week1.第03课_数组_链表_跳表.array;

import util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_3Sum {
    public static void main(String[] args) {
//        int[] nums = {-4, -1, -1, 0, 1, 2};
//        int[] nums = {-2, 0, 0, 2, 2};
//        int[] nums = {-1, -1, 0, 1};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List re = threeSum4(nums);
        System.out.println(re.toString());
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> relist = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            int temp1 = Integer.MIN_VALUE;
            int temp2 = Integer.MAX_VALUE;

            if (nums[i] > 0) {
                break;
            }
            if (i != 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            while (j < k) {
                while (j < k && (nums[i] + nums[j] + nums[k] > 0 || nums[k] == temp2)) {
                    k--;
                }
                while (j < k && (nums[i] + nums[j] + nums[k] < 0 || nums[j] == temp1)) {
                    j++;
                }
                if (j != k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList te = new ArrayList();
                        te.add(nums[i]);
                        te.add(nums[j]);
                        te.add(nums[k]);
                        relist.add(te);

                        temp2 = nums[k--];
                        temp1 = nums[j++];

                    }
                }
            }
        }
        //排序从小到大
        //确定第一个定点 定点大于零 则一定不行， 定点重复则继续
        //左右下标求和 太大则 右边左移，重复则左移
        //太小 左边右移，重复继续右移
        //正好 左右移  右左移
        //
        //
        return relist;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        ArrayList a;

        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) return re;

            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    re.add(Arrays.asList(nums[i], nums[j], nums[k]));   //牢记这个语法
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } else if (nums[i] + nums[j] + nums[k] < 0) j++;
                else if (nums[i] + nums[j] + nums[k] < 0) k--;

            }
            i++;
        }
        return re;
    }

    //复习
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> reList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return reList;
        }
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) return reList;
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> inList = new ArrayList<>();
                    inList.add(nums[i]);
                    inList.add(nums[j]);
                    inList.add(nums[k]);
                    reList.add(inList);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
            }
            i++;

        }

        return reList;
    }


    public static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) return re;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] < 0) j++;
                if(nums[i] + nums[j] + nums[k] > 0) k--;
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    re.add(list);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }

        }

        return re;
    }
//    复习出现的问题，第一个是 continue那里笔误，把i-1 写成i--
    //第二个问题是 没有理清 三个并列if 与 if else的关系，三个if有可能都要执行，但是出现了else 就只能选其中一个
}
