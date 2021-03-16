package secondRound.Week3.第09课_深度优先搜索和广度优先搜索;

import java.util.ArrayDeque;
import java.util.Deque;

public class L200_Number_of_Islands {

    public static void main(String[] args) {

//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1','1'}};
        System.out.println(numIslands2(grid));

    }



    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, -1 ,1};


////////////////dfs
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count  = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, boolean[][] visited, int x, int y){
        //超边界了，  图的内容 以及有没有被访问过
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if(grid[x][y] != '1' || visited[x][y] == true) return;

        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int x_ = x + moveX[i];
            int y_ = y + moveY[i];
            dfs(grid, visited, x_, y_);
        }
    }


//////////////////////////////////////////////////////////////////////bfs
    public static int numIslands2(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void  bfs(char[][] grid, boolean[][] visited, int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] index = queue.poll();

            for(int i = 0; i < 4; i++){
                int newX = index[0] + moveX[i];
                int newY = index[1] + moveY[i];
                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length)continue;

                if(grid[newX][newY] == '1' && !visited[newX][newY]){
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}






//！！！！！！！！！！！！！！！！！！图的问题不管是dfs还是bfs，先弄的visited数组，  和move数组！！！！！！！！！！！！！！！！！！！！
//！！！！！！！！！！！！！！！！！对于递归终止条件的判断      //1超边界了，  2图的内容 3以及有没有被访问过！！！！！！！！！！！！！！！！！！
//
//    void dfs(char[][] grid, boolean[][] visited, int x, int y){
//        //1超边界了，  2图的内容 3以及有没有被访问过
//        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
//        if(grid[x][y] != '1' || visited[x][y] == true) return;
//
//        visited[x][y] = true;
//
//        for(int i = 0; i < 4; i++){
//            int x_ = x + moveX[i];
//            int y_ = y + moveY[i];
//            dfs(grid, visited, x_, y_);
//        }
//    }
//
//    //！！！！！！！！！！！！！！关键点就是  放入队列之后立马就要 标记成 已经被访问过的， 不然队列中会多出很多重复的节点！！！！！！！！！！！
//    void bfs(char[][] grid, boolean[][] visited, int x, int y){
//        Deque<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{x, y});
//        visited[x][y] = true;
//
//        while(!queue.isEmpty()){
//            int[] index = queue.poll();
//
//            for(int i = 0; i < 4; i++){
//                int newX = index[0] + moveX[i];
//                int newY = index[1] + moveY[i];
//                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
//                if(grid[newX][newY] == '1' && !visited[newX][newY]){
//                    queue.offer(new int[]{newX, newY});
//                    visited[newX][newY] = true;
//                }
//            }
//        }
//    }