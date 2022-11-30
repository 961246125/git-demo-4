package example.LeetCode;

public class LeetCode79 {

    public boolean dfs(char[][] board, String word, int index, int i, int j, int[][] matrix) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1) {
            return true;
        }
        matrix[i][j] = 1;
        if(dfs(board, word, index+1, i-1, j, matrix)) {
            return true;
        }
        if(dfs(board, word, index+1, i+1, j, matrix)) {
            return true;
        }
        if(dfs(board, word, index+1, i, j-1, matrix)) {
            return true;
        }
        if(dfs(board, word, index+1, i, j+1, matrix)) {
            return true;
        }
        matrix[i][j] = 0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Boolean temp = dfs(board, word, 0, i, j, matrix);
                    if (temp.equals(true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode79 leetCode79 = new LeetCode79();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEEF";
        System.out.println(leetCode79.exist(board, word));
    }
}
