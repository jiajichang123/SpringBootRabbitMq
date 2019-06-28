package com.jjc.consumption;


import com.jjc.config.RabbitConfig;
import com.jjc.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    // queues是指要监听的队列的名字
   @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic11(User user) {
        System.out.println("【receiveFanout11监听到消息】" + user);
    }

   @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic21(User user) {
        System.out.println("【receiveFanout21监听到消息】" + user);
    }
}