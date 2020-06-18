package firstRound.L118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution0815 {


    public static void main(String[] args) {
        List list = generate(5);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rew = new ArrayList();
        if (numRows == 0) {
            return rew;
        }

        List<Integer> ren = new ArrayList<>();
        ren.add(1);
        rew.add(ren);
        if (numRows == 1) {
            return rew;
        }

        for (int i = 1; i < numRows; i++) {
            ren = new ArrayList<>();
            ren.add(1);

            ArrayList<Integer> renlast = (ArrayList) rew.get(i - 1);
            for (int j = 1; j < i; j++) {
                ren.add(renlast.get(j) + renlast.get(j - 1));
            }
            ren.add(1);

            rew.add(ren);
        }

        return rew;
    }
}
