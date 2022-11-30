package example.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最终连续序列
 * 方法：HashMap
 */
public class Leetcode128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            int k = nums[i];
            if (!map.containsKey(nums[i]-1)) {
                while (map.containsKey(++k)) {
                    temp++;
                }
            }
            result = Math.max(result, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode128 leetcode128 = new Leetcode128();
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(leetcode128.longestConsecutive(nums));
    }
}
