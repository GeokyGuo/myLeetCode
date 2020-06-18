package firstRound.L119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List re = getRow3(30);
        System.out.println(re.toString());

//        int r = getN(10);
//        int s = getN(12);
//        System.out.println(r);
    }

    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);

        int i = 1;
        while (i <= rowIndex) {
            ArrayList<Integer> temp = new ArrayList<>();

            temp.add(1);
            for (int j = 0; j < arr.size() - 1; j++) {
                temp.add(arr.get(j) + arr.get(j + 1));
            }
            temp.add(1);

            i++;
            arr = temp;
        }
        return arr;
    }

    //--------------------------这个方法，放弃，求阶乘的过程，非常非常容易就出现了溢出，慎用求阶乘！！！！------------------------
    public static List<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> re = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            re.add((int) getC(rowIndex, i));
        }

        return re;
    }

    static long getC(int n, int r) {
        if (n == 0 || r == 0 || n == r) {
            return 1;
        }
        return getN(n) / getN(r) / getN(n - r);
    }

    static long getN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getN(n - 1);
        }
    }

    //-----------------------------------------------以上---------------------------------------------------------
    public static List<Integer> getRow3(int rowIndex) {
        ArrayList<Integer> re = new ArrayList<>();
        long temp = 1;
        re.add((int) temp);
        for (int i = 1; i <= rowIndex; i++) {
            temp = temp * (rowIndex - i + 1) / i;
            re.add((int) temp);
        }
        return re;
    }
}
