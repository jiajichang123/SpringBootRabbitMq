package com.jjc.config;

/**
 * Created by jjc on 2019/6/24.
 */
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.channels.Channel;

@Configuration
public class RabbitConfig {
    /**
     * dorable 为 true 代表持久化
     */
    //topic
    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";
    public static final String TOPIC_EXCHANGE = "topic.exchange";

    //fanout
    public static final String FANOUT_QUEUE1 = "fanout.queue1";
    public static final String FANOUT_QUEUE2 = "fanout.queue2";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    //redirect模式
    public static final String DIRECT_QUEUE1 = "direct.queue1";
    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String DIRECT_QUEUE2 ="direct.queue2" ;

    //routingkey
    public static final String ROUTING_KEY1 ="lzc.message" ;
    public static final String ROUTING_KEY2="lzc.#" ;
    public static final String ROUTING_KEY3 ="direct.pwl" ;

    /**
     * Topic模式
     *
     * @return
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1,true);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2,true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE,true,false);
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(ROUTING_KEY1);
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(ROUTING_KEY2);
    }


    /**
     * Fanout模式
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * @return
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE1,true);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2,true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE,true,false);
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }


    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    /**
     * direct模式
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE1,true);
    }
    @Bean
    public Queue directQueue2() {
        return new Queue(DIRECT_QUEUE2,true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE,true,false);
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(ROUTING_KEY3);
    }

}
