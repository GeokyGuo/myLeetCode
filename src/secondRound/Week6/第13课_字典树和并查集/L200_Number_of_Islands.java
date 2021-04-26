package secondRound.Week6.第13课_字典树和并查集;

public class L200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind union = new UnionFind(row * col);
        int space = 0;
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    space++;
                } else {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX < row && newY < col && grid[newX][newY] == '1') {
                            union.union(i * col + j, newX * col + newY);
                        }
                    }
                }
            }
        }
        return union.getCount() - space;
    }

    class UnionFind {
        private int count;
        private int[] fa;

        public UnionFind(int n) {
            this.count = n;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        private int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }
            fa[xRoot] = yRoot;
            count--;
            return;
        }
    }

}

