package example.LeetCode;

import java.util.Stack;

public class Leetcode85 {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] height = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            height[i] = heights[i];
        }
        height[heights.length] = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (stack.size() > 0 && height[stack.peek()] >= height[i]) {
                int h = height[stack.peek()];
                stack.pop();
                int index = stack.size() > 0 ? stack.peek() : -1;
                max = Math.max(max, h * (i - index - 1));
            }
            stack.push(i);
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i-1][j] + 1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            max = Math.max(max, largestRectangleArea(dp[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode85 leetcode85 = new Leetcode85();
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(leetcode85.maximalRectangle(matrix));
    }
}
