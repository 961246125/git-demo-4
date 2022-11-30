package org.example.test;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.*;
import com.alibaba.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import com.alibaba.rocketmq.client.producer.*;
import com.alibaba.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import com.alibaba.rocketmq.shade.io.netty.util.internal.MessagePassingQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

public class RocketMqTest {

    public void sendMsg() throws Exception{
        String body = "hello world";
        Message message = new Message("log-topic", "user-tag", body.getBytes());
        message.setDelayTimeLevel(5); //设置延时等级为5
        /**
         * 生产者
         */
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
        producer.setDefaultTopicQueueNums(5); //设置默认MessageQueue为5个
        producer.setNamesrvAddr("localhost:8080");
        producer.setSendMsgTimeout(3000); //设置超时时间3s
        producer.setRetryTimesWhenSendAsyncFailed(3); //设置超时重试3次
        producer.start();
        /**
         * 消费者
         */
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setMessageModel(MessageModel.BROADCASTING); //设置消费方式：集群消费、广播消费
        consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragely()); //消息分配策略（集群模式才能设置）
        consumer.setMaxReconsumeTimes(10); //并发消费重试：重试次数（时间依次递增,1s,5s,10s,30s,1m,2m...）
        consumer.setSuspendCurrentQueueTimeMillis(500); //顺序消费重试：重试间隔（会不断的消费重试，直到成功，其余消息直接阻塞）
        consumer.setConsumeMessageBatchMaxSize(12);
        consumer.setPullBatchSize(20);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                System.out.println("消息接收完毕");
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        /**
         * 消息发送
         */
        //设置队列选择器，可以将相同订单下的消息放到同一队列中(hashcode、随机、自定义)
        //send的第三个参数arg会传给messageSelector的第三个参数arg
        String orderId = UUID.randomUUID().toString();
        producer.send(message,
                (mqs, msg, arg) -> {
                    int len = mqs.size();
                    int id = (int) arg;
                    // 若希望全局有序，则设置queue数量只有一个或者这里仅选择第一个queue
                    MessageQueue queue = mqs.get(id % len);
                    System.out.println(new String(msg.getBody(), StandardCharsets.UTF_8) + "->" + queue.getQueueId());
                    return queue;
                }, orderId);
        //事务消息发送
        TransactionMQProducer producer1 = new TransactionMQProducer();
        producer1.setTransactionCheckListener((messageExt -> LocalTransactionState.COMMIT_MESSAGE));
        producer1.sendMessageInTransaction(message, (var1,var2) -> LocalTransactionState.COMMIT_MESSAGE, 123);
        //选择器为hashcode
        producer.send(message, new SelectMessageQueueByHash(), orderId);
        producer.shutdown();
    }
}
