package HW牛客.中等;

import java.util.*;

public class test27 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//        String str = in.nextLine();

        int n = in.nextInt();
//        Map<String, Integer> map = new LinkedHashMap<>();

        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String next = in.next();
//            map.put(next, map.getOrDefault(next, 0) + 1);
            wordList.add(next);
        }
        String target = in.next();
        int k = in.nextInt();

        List<String> targetList = new ArrayList<>();
        wordList.forEach(e -> {
            if (isValidWord(e, target)) {
                targetList.add(e);
            }
        });
        System.out.println(targetList.size());

        if (targetList.size() < k) return;

        targetList.sort(String::compareTo);
        System.out.println(targetList.get(k - 1));
    }

    static boolean isValidWord(String str, String target) {
        if (str.equals(target)) return false;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = target.toCharArray();
        Arrays.sort(chars1);

        if (str.length() != target.length()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] != chars1[i]) {
                return false;
            }
        }

        return true;
    }
}


//todo  排序和反转的小结

//数组(字符串数组)
//list
//map
//都可以排序

//反转
//数组 需要转成list进行 Collection.reverse
//字符串 可以用Stringbuffer, 也可以转成list Collection.reverse