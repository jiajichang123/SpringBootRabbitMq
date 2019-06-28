package com.jjc.production;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者（自定义配置-消费者为consumer）
 */
public class Production {
    private String HOST;
    private String USERNAME;
    private String VIRTUAL_HOST;
    private String port;
    private String password;
    private final static String QUEUE_NAME  = "JJC-ONE";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        ConnectionFactory factory = new ConnectionFactory();
        //设置主机名
        factory.setHost("10.231.129.2");
        //创建一个连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //指定一个队列 没有的话  新建
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 发送消息

        String message  = "hello world-3";

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("sent----"+message);
        channel.close();
        connection.close();
    }
}
