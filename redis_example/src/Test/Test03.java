package Test;

import java.util.concurrent.ThreadPoolExecutor;

public class Test03 {

    public int findLongSeque(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxResult = 1;
        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] == k) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            maxResult = Math.max(maxResult, dp[i]);
        }
        return maxResult;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(test03.findLongSeque(nums, 1));
    }
}
