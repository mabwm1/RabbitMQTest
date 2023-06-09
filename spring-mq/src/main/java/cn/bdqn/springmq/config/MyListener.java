package cn.bdqn.springmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
    @RabbitListener(queues = "boot_hello_queue")
    public void receiveMsg(Message message){
        //业务逻辑  Redis  Dao  Log
        byte[] body = message.getBody();
        System.out.println(new String(body));

        MessageProperties messageProperties = message.getMessageProperties(); //参数
        System.out.println(messageProperties.getMessageId());
        System.out.println(messageProperties.getDeliveryTag());
        System.out.println(messageProperties.getReceivedRoutingKey());
        System.out.println(messageProperties.getConsumerTag());
    }
    //频道1
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_1)
    public void receiveMsg1(Message message){
        //业务逻辑  Redis  Dao  Log
        byte[] body = message.getBody();
        System.out.println("频道1："+new String(body));

    }

    //频道1
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_2)
    public void receiveMsg2(Message message){
        //业务逻辑  Redis  Dao  Log
        byte[] body = message.getBody();
        System.out.println("频道2："+new String(body));

    }
}
