package example;

import java.util.Stack;

public class Trap {

    public int trap(int[] height) {
        int maxHight = height[0];
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            int h = Math.min(maxHight, height[i]);
            while(!stack.empty() && height[stack.peek()] <= height[i]) {
                int j = stack.pop();
                if (!stack.empty()) {
                    sum = sum + (h-height[j]) * (j - stack.peek());
                }
            }
            stack.push(i);
            maxHight = Math.max(maxHight, height[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = new int[]{5,4,2,2,0,3,6};
        trap.trap(height);
    }
}
