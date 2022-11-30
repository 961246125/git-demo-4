package example.LeetCode;

/**
 * 岛屿数量
 * 方法：并查集
 */
public class LeetCode200 {

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i*col+j] = i*col+j;
                        count++;
                    }else {
                        parent[i*col+j] = -1;
                    }
                }
            }
        }
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }
        public void merge(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                parent[a] = b;
                count--;
            }
        }
    }




    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i-1][j] == '1') {
                        unionFind.merge((i-1) * col + j, i * col + j);
                    }
                    if (i < row-1 && grid[i+1][j] == '1') {
                        unionFind.merge((i+1) * col + j, i * col + j);
                    }
                    if (j > 0 && grid[i][j-1] == '1') {
                        unionFind.merge(i * col + j - 1, i * col + j);
                    }
                    if (j < col-1 && grid[i][j+1] == '1') {
                        unionFind.merge(i * col + j + 1, i * col + j);
                    }
                }
            }
        }
        return unionFind.count;
    }

    public static void main(String[] args) {
        LeetCode200 leetCode200 = new LeetCode200();
        char[][] grid = new char[][]{
                {'1','0','1','1','0'},
                {'1','1','0','1','1'},
                {'1','0','0','0','1'},
                {'1','1','1','1','1'}};
        System.out.println(leetCode200.numIslands(grid));
    }
}
