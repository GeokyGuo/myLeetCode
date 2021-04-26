package secondRound.Week6.第13课_字典树和并查集;

public class L130_Surrounded_Regions {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        UnionFind uf = new UnionFind(cols * rows + 1);

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.unionFind(i * cols + j, cols * rows);
                    } else {
                        for (int[] direction : directions) {
                            int newX = i + direction[0];
                            int newY = j + direction[1];
                            if (board[newX][newY] == 'O' ) {
                                uf.unionFind(newX * cols + newY, i * cols + j);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (!uf.isConnect(i * cols + j, cols * rows)) {
                    board[i][j] = 'X' ;
                }
            }
        }


    }
    class UnionFind {
        int[] fa;

        UnionFind (int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        void unionFind (int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                fa[xRoot] = yRoot;
                return;
            }
        }

        int find (int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        boolean isConnect (int x, int y) {
            return find(x) == find(y);
        }
    }


}

