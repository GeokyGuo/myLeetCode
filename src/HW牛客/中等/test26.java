package HW牛客.中等;

import java.util.*;

public class test26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        List<Character> listAlph = new ArrayList<>();

        //记录非字母的字符及其位置
        Map<Integer, Character> mapNoAlph = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                listAlph.add(c);
            } else {
                mapNoAlph.put(i, c);
            }
        }

        listAlph.sort(Comparator.comparingInt(Character::toLowerCase));
        mapNoAlph.forEach(listAlph::add);
        listAlph.forEach(System.out::print);
    }


}
