package HW牛客.中等;

import java.math.BigDecimal;
import java.util.Scanner;

public class test107 {//未ac

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal target = in.nextBigDecimal().setScale(1, BigDecimal.ROUND_DOWN);
        boolean flag = false;
        if (target.compareTo(BigDecimal.ZERO) < 0) {
            target = target.multiply(new BigDecimal(-1));
            flag = true;
        }
        BigDecimal last = null;
        for (BigDecimal i = new BigDecimal("0").setScale(1); true; i = new BigDecimal("0.1").add(i)) {
            System.out.println(i);
            if (i.multiply(i).multiply(i).compareTo(target) > 0) {
                last = i;
                break;
            }
        }
        BigDecimal left = last.subtract(new BigDecimal("0.1"));
        BigDecimal right = last;
        BigDecimal res = null;
        BigDecimal divide = left.add(right).divide(new BigDecimal("2"), 2, BigDecimal.ROUND_DOWN);
        if (divide.multiply(divide).multiply(divide).compareTo(target) > 0) {
            res = left;
        } else {
            res = right;
        }
        if (flag) {
            res = res.multiply(new BigDecimal(-1));
        }
        System.out.println(res.setScale(1));

    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Double v = in.nextDouble();
//        BigDecimal target = new BigDecimal(v.toString()).setScale(1, BigDecimal.ROUND_DOWN);
//
//        BigDecimal left = new BigDecimal("0").setScale(1, BigDecimal.ROUND_DOWN);
//        BigDecimal right = target;
//
//        while (left.compareTo(right) < 0) {
//            BigDecimal mid = left.add(right).divide(new BigDecimal("2")).setScale(1, BigDecimal.ROUND_DOWN);// todo
//
//            if (mid.multiply(mid).multiply(mid).compareTo(target) > 0) {
//                right = mid.subtract(new BigDecimal("0.1"));
//            } else {
//                left = mid;
//            }
//        }
//        System.out.println(left.toString());
//    }
}
