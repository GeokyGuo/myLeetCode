package secondRound.Week2.第07课_泛型递归_树的递归.回溯递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47_Permutations_II {
    public static void main(String[] args) {

    }

    List<List<Integer>> reList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums, used, path);
        return reList;
    }

    void permuteUnique(int[] nums, int[] used, List<Integer> path) {

        if (path.size() == nums.length) {
            reList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);

            permuteUnique(nums, used, path);


            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
