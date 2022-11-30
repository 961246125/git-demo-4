package org.example.config;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqProducerConfig {

    public MqProducerConfig() {
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
    }
}
