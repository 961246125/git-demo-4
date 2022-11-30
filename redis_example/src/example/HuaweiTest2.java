package example;

import java.util.*;

public class HuaweiTest2 {

    public static void main(String[] args) {
        String[] strings = new String[2];
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String s = in.next();
        strings = s.split(" ");
        int n = Integer.parseInt(strings[0]);
        int d = Integer.parseInt(strings[1]);
        String[] strings1;
        String s1 = in.next();
        strings1 = s1.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings1[i]);
        }
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] <= d) {
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(nums);
        int[][] dp = new int[2][n];
        int[][] k = new int[2][n];
        dp[0][0] = 0;
        dp[0][1] = 0;
        k[0][0] = 0;
        k[0][1] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] <= d) {
                dp[0][i] = dp[1][i-1]+nums[i]-nums[i-1];
                k[0][i] = k[1][i-1] + 1;
            }else {
                if (k[0][i-1] == k[1][i-1]) {
                    dp[0][i] = Math.min(dp[0][i-1], dp[1][i-1]);
                    k[0][i] = k[0][i-1];
                } else {
                    dp[0][i] = dp[0][i-1];
                    k[0][i] = k[0][i-1];
                }

            }
            dp[1][i] = dp[0][i-1];
            k[1][i] = k[0][i-1];
        }
        if (k[0][n-1] == k[1][n-1]) {
            System.out.println(Math.min(dp[0][n-1], dp[1][n-1]));
        }else {
            System.out.println(dp[0][n-1]);
        }
    }
}
