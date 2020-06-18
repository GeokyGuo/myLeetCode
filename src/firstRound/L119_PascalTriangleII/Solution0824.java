package firstRound.L119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution0824 {

    public static void main(String[] args) {

        List re = getRow(3);
        System.out.println(re.toString());

//        int r = getN(10);
//        int s = getN(12);
//        System.out.println(r);
    }

    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);


        ArrayList<Integer> temp;
        int i = 1;
        while (i <= rowIndex) {
            temp = new ArrayList<>();

            temp.add(1);
            int j = 0;
            while (j < list.size() - 1) {
                temp.add(list.get(j) + list.get(j + 1));
                j++;
            }
            temp.add(1);

            list = temp;
            i++;

        }


        return list;
    }


}
