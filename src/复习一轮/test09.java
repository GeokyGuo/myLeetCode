package 复习一轮;

import util.TreeNode;

import java.util.*;

public class test09 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    //102
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>(); //todo 要用队列
        queue.offer(root);
        List<Integer> row;
        while (!queue.isEmpty()) {
            row = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                row.add(pop.val);
                if (pop.left != null) queue.offer(pop.left);
                if (pop.right != null) queue.offer(pop.right);
            }
            res.add(row);
        }
        return res;
    }

    //433
    int min = Integer.MAX_VALUE;
    ArrayList<Character> list = new ArrayList<>(Arrays.asList('A', 'C', 'G', 'T'));

    public int minMutation(String startGene, String endGene, String[] bank) {
        ArrayList<String> bankList = new ArrayList<>(Arrays.asList(bank));
        dfsminMutation(new HashSet<String>(), endGene, startGene, 0, bankList);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfsminMutation(HashSet<String> visited, String end, String s, int stepCount, ArrayList<String> bankList) {
        if (end.equals(s)) {
            min = min < stepCount ? min : stepCount;
        }

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (Character character : list) {
                chars[i] = character;
                String s1 = String.valueOf(chars);
                if (!visited.contains(s1) && bankList.contains(s1) && !s1.equals(s)) {
                    visited.add(s1);
                    dfsminMutation(visited, end, s1, stepCount + 1, bankList);
                }
            }
        }
    }

    //127
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet(wordList);
        wordSet.remove(beginWord);

        int i = bfsfindLadders(beginWord, wordSet, endWord);
        return i;
    }

    public int bfsfindLadders(String beginWord, HashSet<String> wordSet, String endWord) {
        Deque<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet();
        queue.offer(beginWord);

        int count = 1;
        if (beginWord.equals(endWord)) {
            return count;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            //遍历队列中 当前层的每一个字符串
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                //开始找每一个邻接字符串
                //遍历当前字符串的每一个元素
                for (int j = 0; j < chars.length; j++) {
                    Character temp = chars[j];

                    //把某个位  遍历从a到z
                    for (char k = 'a'; k <= 'z'; k++) {//todo z 忘记写
                        chars[j] = k;
                        //得到新的可能的邻接字符串
                        String newStr = String.valueOf(chars);

                        //判断邻接字符串，没有访问过，出现在字典中才算有效
                        if (!visited.contains(newStr) && wordSet.contains(newStr)) {
                            //若有效，
                            //  若得到最终字符串，return count+1
                            //  若未得到最终字符串，则把邻接字符串放到队列中
                            if (newStr.equals(endWord)) {
                                return count + 1;
                            } else {
                                visited.add(newStr);
                                queue.offer(newStr);
                            }
                        }
                    }
                    chars[j] = temp;
                }
            }
            //当前层遍历完，层次号加1
            count++;
        }

        //bfs结束没有找到合适的路径，返回0
        return 0;
    }


    //200
    public int numIslands(char[][] grid) {
        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '1' || visited[i][j]) continue;
                dfsnumIslands(i, j, moveX, moveY, visited, grid);
                count++;
            }
        }
        return count;
    }

    void dfsnumIslands(int y, int x, int[] moveX, int[] moveY, boolean[][] visited, char[][] grid) {
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length) return; // todo 注意两个递归条件 注意行于列
        if (grid[y][x] != '1' || visited[y][x]) return;   //todo 字符


        visited[y][x] = true;
        for (int k = 0; k < 4; k++) {
            int newX = moveX[k] + x;
            int newY = moveY[k] + y;
            dfsnumIslands(newY, newX, moveX, moveY, visited, grid);
        }
    }


    //todo  bfs 入队时就要把 visited设置为 true，否则可能会重复入队！！！
    void bfsnumIslands(int oldy, int oldx, int[] moveX, int[] moveY, boolean[][] visited, char[][] grid) {
        Deque<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{oldy, oldx});
        visited[oldy][oldx] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y_ = poll[0];
            int x_ = poll[1];


            for (int i = 0; i < moveX.length; i++) {
                int newY = moveY[i] + y_;
                int newX = moveX[i] + x_;

                if (newX < 0 || newX >= grid[0].length || newY < 0 || newY >= grid.length) continue;
                if (visited[newY][newX] || grid[newY][newX] != '1') continue;

                queue.offer(new int[]{newY, newX});
                visited[newY][newX] = true;
            }
        }
    }



}
