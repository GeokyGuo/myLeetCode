package 复习一轮;

import java.util.*;

public class test05 {
    public static void main(String[] args) {

    }


    //49
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            map.computeIfAbsent(newString, k -> new ArrayList<>()).add(str);

        }
        for (List<String> value : map.values()) {
            res.add(value);
        }

        return res;
    }

    //242
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);

        return Objects.equals(new String(cs),new String(ct));
    }


}
