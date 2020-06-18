package firstRound.L118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        List list = generate(2);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> re = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return re;
        }

        ArrayList<Integer> arr1 = new ArrayList();
        arr1.add(1);
        re.add(arr1);

        int i = 1;
        while (i < numRows) {
            ArrayList<Integer> a = new ArrayList();
            a.add(0, 1);
            ArrayList<Integer> li = (ArrayList) re.get(i - 1);
            for (int j = 1; j < li.size(); j++) {
                a.add(j, li.get(j) + li.get(j - 1));
            }
            a.add(i, 1);
            re.add(i, a);

            i++;
        }

        return re;
    }
}
