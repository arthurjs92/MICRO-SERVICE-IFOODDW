package com.ifooddw.deliveryman.message;

import com.ifooddw.deliveryman.model.DeliveryMan;
import com.ifooddw.deliveryman.model.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeliveryManSendMessage {

    @Value("${deliveryMan.rabbitmq.exchange}")
    String exchange;

    @Value("${deliveryMan.rabbitmq.routingkey}")
    String routingKey;

    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public DeliveryManSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Log log) {
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }

}
