package HW牛客.简单;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class test94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int j = 0; j < i; j++) {
            String next = in.next();
            map.put(next, 0);
        }
        map.put("Invalid", 0);

        int n = in.nextInt();
        for (int j = 0; j < n; j++) {
            String next = in.next();
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                map.put("Invalid", map.get("Invalid") + 1);
            }
        }

        map.forEach((k, v) -> System.out.print(k + " : " + v));

    }
}
