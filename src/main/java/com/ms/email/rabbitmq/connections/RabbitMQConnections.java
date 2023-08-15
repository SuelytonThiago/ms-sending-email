package com.ms.email.rabbitmq.connections;

import com.ms.email.rabbitmq.contants.RabbitMQConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnections {

    private static final String NAME_EXCHANGE = "amq.direct";

    @Autowired
    private AmqpAdmin amqpAdmin;

    private Queue queue(String nameQueue){
        return new Queue(nameQueue, true);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding binding(Queue queue,DirectExchange exchange){
        return new Binding(
                queue.getName(),
                Binding.DestinationType.QUEUE,
                exchange.getName(),
                queue.getName(),
                null
        );
    }

    @PostConstruct
    private void add(){
        Queue queueEmail =this.queue(RabbitMQConstants.QUEUE_EMAIL);

        DirectExchange exchange =this.directExchange();

        Binding bindingEmail =this.binding(queueEmail,exchange);

        this.amqpAdmin.declareQueue(queueEmail);
        this.amqpAdmin.declareExchange(exchange);
        this.amqpAdmin.declareBinding(bindingEmail);
    }
}
