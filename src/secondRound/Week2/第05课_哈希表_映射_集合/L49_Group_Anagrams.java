package secondRound.Week2.第05课_哈希表_映射_集合;

import java.util.*;

public class L49_Group_Anagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);

    }

    //方法一  排序后的值作为 hash的key的特征
    //学会map.value() 这个方法,可以得到一个colection
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String sortStr = String.valueOf(strChar);

            if (!map.containsKey(sortStr)) map.put(sortStr, new ArrayList<>());
            map.get(sortStr).add(str);
        }
        return new ArrayList(map.values());
    }

    //方法二  用自建26个数组，建立hash 的key 特征
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List> map = new HashMap<>();

        int[] table = new int[26];
        for (String str : strs) {
            Arrays.fill(table, 0);

            char[] strChar = str.toCharArray();
            for (char c : strChar) {
                int index = c - 'a';
                table[index]++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i : table) {
                sb.append(i);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);

        }
        return new ArrayList(map.values());
    }

//这个题的本质就是 要找出可以分到一组的数的公共特征， 然后把这个公共特征当成 map中key
    //找公共特征，一种用到  排序， 一种用到 建立asci 的词频，  liweiwei用到 把每个字符对应到一个质数，然后相乘

}
