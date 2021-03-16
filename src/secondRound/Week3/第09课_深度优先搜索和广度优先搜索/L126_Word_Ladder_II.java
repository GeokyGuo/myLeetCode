package secondRound.Week3.第09课_深度优先搜索和广度优先搜索;

import java.util.*;

public class L126_Word_Ladder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        //第二步 dfs根据后继节点回溯 去找路径List<List<String>>
        List<List<String>> resList = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);
        wordList.remove(beginWord);


        //第一步bfs先找 后继节点Map<String, Set<String>> map
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, successors);
        if(!found) return resList;

        //第二步 dfs根据后继节点回溯 去找路径List<List<String>>
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(resList, path, beginWord, endWord, successors);
        return resList;
    }

    boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors){
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Set<String> nextLevelVisites = new HashSet<>();
        boolean found = false;
        while(!queue.isEmpty()){
            int size = queue.size();

            //遍历当前层的所有字符串
            for(int i = 0; i < size; i++){
                String str = queue.poll();
                char[] charArray = str.toCharArray();
                //遍历当前字符串的每一个字符
                for(int j = 0; j < charArray.length; j++){
                    char origin = charArray[j];
                    //遍历当前字符的所有可能
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == origin) continue;
                        charArray[j] = ch;
                        String nextStr = String.valueOf(charArray);

                        //合法
                        if(wordSet.contains(nextStr)){
                            //没访问过
                            if(!visited.contains(nextStr)){
                                //是否成功了
                                if(nextStr.equals(endWord)){
                                    found = true;
                                }
                                //成功与否要放的预置的下一层去访问
                                if(!nextLevelVisites.contains(nextStr)){
                                    queue.offer(nextStr);
                                    nextLevelVisites.add(nextStr);
                                }
                                //构建后继节点集合
                                if(!successors.containsKey(str)) successors.put(str, new HashSet<String>());

                                successors.get(str).add(nextStr);
                            }
                        }
                    }
                    charArray[j] = origin;
                }
            }
            if(found){
                break;
            }
            visited.addAll(nextLevelVisites);//addAll??
            nextLevelVisites.clear();
        }
        return found;
    }

    void dfs(List<List<String>> resList, List<String> path, String curString, String endWord,Map<String, Set<String>> successors){
        if(curString.equals(endWord)){
            resList.add(new ArrayList<>(path));
            return;
        }

        //后继节点不一定在keys 列表中
        if (!successors.containsKey(curString)) {
            return;
        }
        Set<String> set = successors.get(curString);
        for(String str :set){
            path.add(str);
            dfs(resList, path, str, endWord, successors);
            path.remove(path.size() - 1);
        }

    }
}

//使用了邻接表的思想，bfs先构建出邻接表（边遍历边构建图）， 然后用dfs在邻接表中进行回溯，找到最短路径


//一遍bfs的思路，大佬，多看看
//https://leetcode-cn.com/problems/word-ladder-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-3/