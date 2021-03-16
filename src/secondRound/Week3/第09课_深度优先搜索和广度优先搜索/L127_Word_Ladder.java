package secondRound.Week3.第09课_深度优先搜索和广度优先搜索;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class L127_Word_Ladder {
    static int min = Integer.MAX_VALUE;
    static Set<String> set = new HashSet<>();
    static ArrayList<String> array = new ArrayList<>();



    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] s = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> arr = Arrays.asList(s);
        int a = ladderLength2(begin, end, arr);
        System.out.println(a);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set.add(beginWord);

        dfs(wordList, 1, beginWord, endWord);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    static void dfs(List<String> wordList, int stepCount, String curString, String endWord) {
        if (curString.equals(endWord)) {
            min = stepCount < min ? stepCount : min;
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.size() - 1 == i) {
                System.out.println(i);
            }
            String temp = wordList.get(i);

            int diff = 0;
            for (int j = 0; j < curString.length(); j++) {
                if (curString.charAt(j) != temp.charAt(j)) diff++;
            }
            if(diff > 1) continue;
            if (diff == 1 && !set.contains(temp)) {
                set.add(temp);
                dfs(wordList, stepCount + 1, temp, endWord);
                set.remove(temp);
            }
        }

    }




//---------------------------------------------------------------------------
public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Deque<String> deque = new ArrayDeque<>();


    Set<String> wordSet = new HashSet<>(wordList);
    wordSet.remove(beginWord);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    deque.offerLast(beginWord);

    int step = 1;
    while(!deque.isEmpty()){
        // 遍历当前层
        int k = deque.size();
        for(int i = 0; i < k; i++){
            String str = deque.pollFirst();
            char[] strArray = str.toCharArray();//TODO

            //为字符串的每一位都进行遍历，判断能否进入下一层
            for(int j = 0; j < strArray.length; j++){
                char origin = strArray[j];

                //对字符串的当前位进行遍历，判断能否进入下一层
                for(char ch = 'a'; ch < 'z' + 1; ch++){
                    if(i == origin) continue;
                    strArray[j] = ch;
                    String nextStr = String.valueOf(strArray);//TODO
                    //是否合法
                    if(wordSet.contains(nextStr)){
                        if(!visited.contains(nextStr)){
                            if(nextStr.equals(endWord)) {
                                return step + 1;
                            }else {
                                deque.offerLast(nextStr);
                                visited.add(nextStr);
                            }
                        }
                    }
                }
                strArray[j] = origin;
            }
        }
        step++;
    }
    return 0;
}
    //学习两个方法 string和char[] 的转换
    //char[] strArray = str.toCharArray();//TODO
    //String nextStr = String.valueOf(strArray);//TODO
}
