package org.example.test;

import com.alibaba.rocketmq.common.message.Message;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class WmbMessage {

    private Queue<Message>[] partitions;

    public int selector(Object object) {
        int hash = object.hashCode();
        return hash % partitions.length;
    }

    public void sendMessage(String key, Message message) {
        int selectPatition = selector(key);
        Queue<Message> partition = partitions[selectPatition];
        partition.add(message);
    }

    public void consume(int select) {
        Queue<Message> partition = partitions[select];
        if (partition.isEmpty()) {
            return;
        }
        Message messge = partition.poll();
        System.out.println("消费message");

    }
}
