package example.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }else {
                    dp[i] = false;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode139 leetCode139 = new LeetCode139();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        leetCode139.wordBreak(s, wordDict);
    }
}
