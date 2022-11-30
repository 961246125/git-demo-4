package org.example.test1;

public class Test1 {

    public boolean dfs(int[][] matrix, int index, int[] flag) {
        int n = matrix.length;
        if (flag[index] == 1) {
            return true;
        }
        flag[index] = 1;
        for (int i = 0; i < n; i++) {
            if (matrix[index][i] == 1) {
                boolean temp = dfs(matrix, i, flag);
                if (temp) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isLoop(int[][] matrix) {
        int n = matrix.length;
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                boolean temp = dfs(matrix, i, flag);
                if (temp) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[][] matrix = new int[][]{
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,1},
                {0,0,0,0,0}};
        System.out.println(test1.isLoop(matrix));
    }
}
