package example;

import java.util.*;

public class CombinationSum {
    public void dfs(int left, int[] candidates, List<List<Integer>> result, List<Integer> temp, int target) {
        if (left >= candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = left; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(i, candidates, result, temp, target - candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, candidates, result, temp, target);
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.empty();
        Queue<Integer> queue =new ArrayDeque<>();

        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> result = combinationSum.combinationSum(candidates, 7);
    }
}
