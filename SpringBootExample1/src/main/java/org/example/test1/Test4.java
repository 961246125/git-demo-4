package org.example.test1;

public class Test4 {

    public int findMax(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i-1] <= 0) {
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1] + nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test4.findMax(nums));
    }
}
