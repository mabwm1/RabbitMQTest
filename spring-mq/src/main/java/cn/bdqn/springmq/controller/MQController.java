package cn.bdqn.springmq.controller;

import cn.bdqn.springmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("mq")
public class MQController {

    @Resource
    RabbitTemplate rabbitTemplate;

    @GetMapping("/test1")
    public String test1(){
        System.out.println("test1");
        // 消息队列
        rabbitTemplate.convertAndSend("boot_hello_queue","test消息");
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        System.out.println("test2");
        // 消息队列
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_QUEUE_1,"体育新闻");
        return "test2";
    }

    @GetMapping("/test3")
    public String test3(){
        System.out.println("test3");
        // 消息队列
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_QUEUE_2,"娱乐新闻");
        return "test3";
    }
}
