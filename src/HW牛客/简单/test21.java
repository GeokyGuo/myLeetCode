package HW牛客.简单;

import java.util.HashMap;
import java.util.Scanner;

public class test21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();

        HashMap<Character, Character> map = new HashMap();
        initMap(map);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);

            //是否为小写
            if (islowChar(c)) {
                Character character = map.get(c);
                sb.append(character);
            }

            //是否为大写//
            else if (isupChar(c)) {
                Character character = getupMapChar(c);
                sb.append(character);
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);

    }

    private static void initMap(HashMap<Character, Character> map) {
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');
    }

    private static Character getupMapChar(char c) {
        if(c == 'Z') return 'a';
        char res = (char) (c - 'A' + 'a' + 1);
        return res;
    }

    private static boolean islowChar(char c) {
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    private static boolean isupChar(char c) {
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }
}
