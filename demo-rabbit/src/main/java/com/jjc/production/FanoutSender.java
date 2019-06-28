package com.jjc.production;

import com.jjc.config.RabbitConfig;
import com.jjc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jjc on 2019/6/24.
 */
@RestController
@RequestMapping
@Slf4j
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @PostMapping("FanoutSender")
    public void send(@RequestBody User user){
       this.amqpTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE,RabbitConfig.ROUTING_KEY1,user);
    }
}
