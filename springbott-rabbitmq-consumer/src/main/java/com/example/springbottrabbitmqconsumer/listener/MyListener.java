package com.example.springbottrabbitmqconsumer.listener;

import com.example.springbottrabbitmqconsumer.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 *
 *
 */
@Component
public class MyListener {

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_1)
    public void receiveMsg(Message message){
        //业务逻辑
        byte[] body = message.getBody();
        System.out.println(new String(body));

        MessageProperties messageProperties = message.getMessageProperties(); //参数
        System.out.println(messageProperties.getMessageId());
        System.out.println(messageProperties.getDeliveryTag());
        System.out.println(messageProperties.getReceivedRoutingKey());
        System.out.println(messageProperties.getConsumerTag());
    }

}
