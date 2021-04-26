package secondRound.Week8.第20课_字符串算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = getHash(str);
            // System.out.print(hash);
            List list = map.getOrDefault(hash, new ArrayList<String>());
            list.add(str);
            map.put(hash, list);
        }
        return new ArrayList(map.values());
    }

    String getHash(String str) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (int i : arr) {
            sb.append(i + "#");
        }
        return sb.toString();
    }

    //两点，第一这个方法 new ArrayList(map.values());
    //第二 getOrDefault()  这个方法后，要记得put
}
