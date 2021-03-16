package secondRound.Week2.第07课_泛型递归_树的递归.回溯递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L78_Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List li = subsets(nums);
        System.out.println(li.toString());

    }


    static List<List<Integer>> relist = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        List<Integer> inList = new ArrayList<>();
        subsets(nums, inList, 0);
        return relist;
    }

    public static void subsets(int[] nums, List<Integer> inList, int start) {
        relist.add(new ArrayList<>(inList));
        for (int i = start; i < nums.length; i++) {
            inList.add(nums[i]);
            subsets(nums, inList, i + 1);
            inList.remove(inList.size() - 1);
        }

    }

    //    复习
    public static List<List<Integer>> subsetsF(int[] nums) {
        List<List<Integer>> reList = new ArrayList<>();
        subsetsF(nums, reList, new ArrayList<Integer>(), 0);
        return reList;
    }

    public static void subsetsF(int[] nums, List<List<Integer>> reList, List<Integer> path, int start) {
        reList.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsF(nums, reList, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
