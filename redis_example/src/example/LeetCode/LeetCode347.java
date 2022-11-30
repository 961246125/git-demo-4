package example.LeetCode;

import java.util.*;

public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int temp = map.get(nums[i]);
                map.put(nums[i], temp+1);
            }else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode347 leetCode347 = new LeetCode347();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 3;
        int[] result = leetCode347.topKFrequent(nums, k);
        for (int i = 0; i < k; i++) {
            System.out.println(result[i]);
        }
    }
}
