package HW牛客.简单;

import java.util.*;

public class test13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(s1));
        Collections.reverse(list);
        list.forEach(e -> System.out.print(e + " "));
    }

}
