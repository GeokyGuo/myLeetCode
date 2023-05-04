package HW牛客.简单;

import java.util.*;

public class test102 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);

        list.sort((o1, o2) -> {
            int i = o2.getValue() - o1.getValue();
            if(i!=0) return i;
            return o1.getKey() - o2.getKey();
        });

        list.forEach(e -> System.out.print(e.getKey()));
    }
}

