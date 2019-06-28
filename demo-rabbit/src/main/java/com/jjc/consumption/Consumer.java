package com.jjc.consumption;

import com.rabbitmq.client.*;
import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者（自定义配置-生产者为production）
 */
public class Consumer {
    private final static String QUEUE_NAME = "JJC-ONE";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        ConnectionFactory factory = new ConnectionFactory();
         //设置主机名--连接的主机名
        factory.setHost("10.231.129.2");
         //创建一个连接
        Connection connection = factory.newConnection();
         //创建通道
        Channel channel = connection.createChannel();
        //指定队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Received Message '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);
    }
}

