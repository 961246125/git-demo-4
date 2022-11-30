package example;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public String maxDictionaryOrder (String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        char[] a = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            while (!stack.empty() && stack.peek() < a[i]) {
                stack.pop();
            }
            stack.push(a[i]);
        }
        StringBuffer result = new StringBuffer();
        while (!stack.empty()) {
            result = result.append(stack.pop());
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String result = s.maxDictionaryOrder("cmbchina");
        System.out.println(result);
    }
}