package org.example.test;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import lombok.Data;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Test01 implements Fly, Run {

    @Resource
    private static RedisTemplate<String, Object> redisTemplate;

    public volatile String name;

    private int age;

    @Override
    public void fly() {
        System.out.println("我要飞");
    }

    @Override
    public void run() {
        System.out.println("我要跑");
    }

    public synchronized void getRedis(String key) throws Exception{
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        ListOperations<String, Object> stringObjectListOperations = redisTemplate.opsForList();

    }
}
