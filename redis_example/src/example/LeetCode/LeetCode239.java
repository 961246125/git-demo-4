package example.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];});
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int n = nums.length;
        int[] result = new int[n-k+1];
        result[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            while(queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i-k+1] = queue.peek()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
        int[] nums = new int[]{2,3,6,5,4,3,2,1,0,-1};
        int k = 3;
        System.out.println(Arrays.toString(leetCode239.maxSlidingWindow(nums, k)));
    }
}
