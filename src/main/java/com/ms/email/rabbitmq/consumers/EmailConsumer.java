package com.ms.email.rabbitmq.consumers;

import com.ms.email.rabbitmq.contants.RabbitMQConstants;
import com.ms.email.rest.dto.EmailRequestDto;
import com.ms.email.domain.entities.Emails;
import com.ms.email.rest.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMQConstants.QUEUE_EMAIL)
    private void consumer(EmailRequestDto requestDto){
        Emails emails = new Emails();
        BeanUtils.copyProperties(requestDto,emails);
        emailService.sendEmail(emails);

    }
}
