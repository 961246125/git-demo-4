package example.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *  和为 K 的子数组
 *  方法：前缀和
 */
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int[] pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < 1) {
                pre[i] = nums[0];
            }else {
                pre[i] = pre[i-1] + nums[i];
            }
            if(map.containsKey(pre[i] - k)) {
                sum += map.get(pre[i] - k);
            }
            if (map.containsKey(pre[i])) {
                map.put(pre[i], map.get(pre[i])+1);
            }else {
                map.put(pre[i], 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Leetcode560 leetcode560 = new Leetcode560();
        int[] nums = new int[]{3,-3,3,-3,3};
        System.out.println(leetcode560.subarraySum(nums, 3));
    }
}
