package example.LeetCode;

import java.util.Stack;

/**
 * 每日温度
 * 方法：单调栈
 */
public class Leetcode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] dp = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            dp[i] = 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int tempi = stack.peek();
                stack.pop();
                dp[tempi] = i - tempi;
            }
            stack.push(i);
        }
        return dp;
    }

    public static void main(String[] args) {
        Leetcode739 leetcode739 = new Leetcode739();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] result = leetcode739.dailyTemperatures(temperatures);
    }
}
