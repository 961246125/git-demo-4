package example.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和（简单）
 */
public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        /**
         * HashMap
         */
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
//        /**
//         * 双指针
//         */
//        int[] result = new int[2];
//        int[] sortNum = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            sortNum[i] = nums[i];
//        }
//        Arrays.sort(sortNum);
//        int left = 0;
//        int right = nums.length-1;
//        while (left < right) {
//            if (sortNum[left] + sortNum[right] == target) {
//                break;
//            }else if (sortNum[left] + sortNum[right] > target) {
//                right--;
//            }else {
//                left++;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (left >= 0 && nums[i] == sortNum[left]) {
//                result[0] = i;
//                left = -1;
//            }else if (nums[i] == sortNum[right]) {
//                result[1] = i;
//            }
//        }
//        return result;
    }

    public static void main(String[] args) {
        Leetcode1 leetcode1 = new Leetcode1();
        int[] nums = new int[]{2,5,5,11};
        int target = 10;
        int[] result = leetcode1.twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
