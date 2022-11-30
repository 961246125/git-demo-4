package example.LeetCode;

import java.util.*;

public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < n-2; k++) {
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int i = k+1;
            int j = n-1;
            while(i < j) {
                int s = nums[k] + nums[i] + nums [j];
                if (s < 0) {
                    while(i < j && nums[++i] == nums[i-1]) {}
                } else if (s > 0) {
                    while(i < j && nums[--j] == nums[j+1]) {}
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    result.add(temp);
                    while(i < j && nums[++i] == nums[i-1]) {}
                    while(i < j && nums[--j] == nums[j+1]) {}
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        leetCode15.threeSum(nums);
    }
}
