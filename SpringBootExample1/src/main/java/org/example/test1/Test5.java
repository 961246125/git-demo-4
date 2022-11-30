package org.example.test1;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.servlet.FilterChain;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Test5 {
    public int dfs(int[][] martix, int[][] dp, int i, int j) {
        int row = martix.length;
        int col = martix[0].length;
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i >= 1 && martix[i-1][j] < martix[i][j]) {
            up = dfs(martix, dp, i-1, j);
        }
        if (i <= row-2 && martix[i+1][j] < martix[i][j]) {
            down = dfs(martix, dp, i+1, j);
        }
        if (j >= 1 && martix[i][j-1] < martix[i][j]) {
            left = dfs(martix, dp, i, j-1);
        }
        if (j <= col-2 && martix[i][j+1] < martix[i][j]) {
            right = dfs(martix, dp, i, j+1);
        }
        dp[i][j] = Math.max(Math.max(Math.max(up, down),left),right) + 1;
        return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = dfs(matrix, dp, i, j);
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        Test5 test5 = new Test5();
        int[][] martix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(test5.longestIncreasingPath(martix));
//        CountDownLatch countDownLatch = new CountDownLatch(5);
//        try {
//            countDownLatch.await();
//            countDownLatch.await();
//            countDownLatch.await();
//        }catch (Exception e) {
//        }
//        countDownLatch.countDown();
//        LongAdder longAdder = new LongAdder();
//        longAdder.increment();
//        longAdder.longValue();
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
//        cyclicBarrier.await();
//        cyclicBarrier.reset();

        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.opsForHash().put("123","456","123");
        ZSetOperations<String, String> zSet = redisTemplate.opsForZSet();
        zSet.add("key1", "a", 1);
        zSet.add("key1", "b", -1);
        zSet.add("key1", "c", 3);
        zSet.add("key1", "d", 2);
        zSet.add("key1", "e", 0);

    }
}
