package secondRound.Week2.第07课_泛型递归_树的递归.回溯递归;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L46_Permutations {
    public static void main(String[] args) {

    }

    List<List<Integer>> reList = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        permute(nums, new ArrayList<Integer>(), set);
        return reList;
    }

    void permute(int[] nums, List<Integer> inList, Set<Integer> set) {
        if (inList.size() == nums.length) {
            reList.add(new ArrayList<>(inList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            inList.add(nums[i]);

            permute(nums, inList, set);
            inList.remove(inList.size() - 1);
            set.remove(i);
        }
    }
}
