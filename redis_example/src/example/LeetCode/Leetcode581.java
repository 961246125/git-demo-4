package example.LeetCode;

/**
 * 最短无序连续子数组
 */
public class Leetcode581 {

    public int findUnsortedSubarray(int[] nums) {
        int end = 0;
        int begin = nums.length-1;
        int max = nums[0];
        int min = nums[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            }else {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums.length-i-1] > min) {
                begin = nums.length-i-1;
            }else {
                min = nums[nums.length-i-1];
            }
        }
        return end > begin ? end-begin+1 : 0;
    }

    public static void main(String[] args) {
        Leetcode581 leetcode581 = new Leetcode581();
        int[] nums = new int[]{1};
        System.out.println(leetcode581.findUnsortedSubarray(nums));
    }
}
