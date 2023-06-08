package cn.bdqn.springbootrabbitmqproducer;

import cn.bdqn.springbootrabbitmqproducer.config.RabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqProducerApplication.class)
public class ProducerTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void helloTest(){
        String msg="hello rabbitmq!";
        rabbitTemplate.convertAndSend("","boot_hello_queue",msg);
    }

    @Test
    public void publishTest(){
        String msg="hello rabbitmq!publishTest";
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHAGE,"",msg);
    }

    //作业 routing
    //topic
}
