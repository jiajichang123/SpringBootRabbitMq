package com.jjc.production;

import com.jjc.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by jjc on 2019/6/24.
 */
public class FanoutSenderTest {
    @Autowired
    private FanoutSender fanoutSender;
/*    @Autowired
    private TopicSender topicSender;
    @Autowired
    private DirectSender directSender;*/

    /**
     * Fanout测试
     * @throws Exception
     */
    @Test
    public void testFanout() throws Exception {
        User user=new User();
        user.setId("1");
        user.setName("pwl");
        fanoutSender.send(user);
    }


}