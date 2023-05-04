package HW牛客.中等;

import java.util.*;

public class test59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Character res = getChar(s);
        System.out.println(res == null ? -1 : (res + ""));
    }

    static class Node {
        int index;
        int count;

        Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private static Character getChar(String s) {
        Map<Character, Node> map = new LinkedHashMap<>();//todo  排序时一定记得使用linkedmap

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Node node = map.getOrDefault(chars[i], new Node(i, 0));
            node.count = node.count + 1;
            map.put(chars[i], node);
        }
        List<Map.Entry<Character, Node>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            return o1.getValue().count - o2.getValue().count;
        });

        Map.Entry<Character, Node> characterNodeEntry = list.get(0);
        if (characterNodeEntry.getValue().count == 1) return characterNodeEntry.getKey();
        return null;
    }
}
