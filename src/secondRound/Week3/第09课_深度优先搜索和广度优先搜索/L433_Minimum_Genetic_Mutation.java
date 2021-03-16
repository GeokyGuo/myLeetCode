package secondRound.Week3.第09课_深度优先搜索和广度优先搜索;

import java.util.*;

public class L433_Minimum_Genetic_Mutation {


    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};

        System.out.println(minMutation2(start,end,bank));
    }


    /////////////弃用这种回溯方法
    int min = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(bank, new HashSet<String>(), start, end, 0);
        return min == Integer.MAX_VALUE ? -1 : min;

    }
    void dfs(String[] bank, Set<String> set, String curString, String end, int stepCount){
        if(curString.equals(end)){
            min = min < stepCount ? min : stepCount;
        }
        for(String str :bank){
            int diff = 0;
            for(int i = 0; i < curString.length(); i++){
                if(curString.charAt(i) != str.charAt(i)) diff++;
            }
            if(diff > 1) continue;

            if(diff == 1 && !set.contains(str)){
                set.add(str);
                dfs(bank, set, str, end, stepCount + 1);
                set.remove(str);
            }
        }
    }


////////////////////////////bfs
    static char[] genArray = {'A', 'C', 'G', 'T'};

    public static int minMutation2(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();


        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        bankSet.remove(start);

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            //遍历当前层的所有单词
            for(int i = 0; i < size; i++){
                String str = queue.poll();
                char[] chArray = str.toCharArray();

                //遍历当前单词的每一位
                for(int j = 0; j < chArray.length; j++){
                    char origin = chArray[j];

                    //把当前位更换成所有情况
                    for(char ch : genArray){
                        chArray[j] = ch;
                        String temp = String.valueOf(chArray);
                        if(bankSet.contains(temp)){
                            if(!visited.contains(temp)){
                                if(temp.equals(end)) return step;
                                queue.offer(temp);
                                visited.add(temp);
                            }
                        }
                    }

                    chArray[j] = origin;
                }
            }
            step++;
        }
        return -1;
    }











}






//Integer.MAX_VALUE 注意拼写正确
//set.contains map.containsKey  注意区别

//回溯与 dfs 本质一样，
// 只是 回溯是把所有其它节点都当成自己的子节点（每个节点的 剩余其它节点都一样），只需要关注剪枝，（可能需要用到set去判断哪些节点已经使用）
// dfs要知道 当前节点的子节点（每个节点都不一样，相当于从结构上已经有了一个set，保证不会去访问其它节点的子节点） 才能遍历， 也可以添加剪枝，
//
// 如果只知道一个节点，也不知道谁是分支，就要增加复杂度去判断每个节点的子节点，这个时候，不如直接用回溯，把其它节点全都当成子节点，然后去剪枝就好