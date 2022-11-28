package com.ifooddw.log.message;

import com.ifooddw.log.model.Log;
import com.ifooddw.log.service.LogServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class logReceiveMessage {

    @Autowired
    private LogServiceImpl logServiceImpl;

    @RabbitListener(queues = {"${logSystem.rabbitmq.queue}"})
    public void receive(@Payload Log log) {
        logServiceImpl.createLog(log);
    }

}
