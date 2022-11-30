package example.LeetCode;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class Leetcode84 {
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
                max = Math.max(max, h*(i - index -1));
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode84 leetcode84= new Leetcode84();
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(leetcode84.largestRectangleArea(heights));
    }
}
