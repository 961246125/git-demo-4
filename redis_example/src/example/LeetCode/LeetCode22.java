package example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode22 {

    public void dfs(List<String> result, StringBuilder stringBuilder, int left, int right, int index, int n) {
        if (index == 2 * n) {
            result.add(stringBuilder.toString());
            return;
        }
        if (left < n) {
            stringBuilder.append("(");
            dfs(result, stringBuilder, left + 1, right, index + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (left > right && right < n) {
            stringBuilder.append(")");
            dfs(result, stringBuilder, left, right + 1, index + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        dfs(result, stringBuilder, left, right, index, n);
        return result;
    }

    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        List<String> result = leetCode22.generateParenthesis(1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
