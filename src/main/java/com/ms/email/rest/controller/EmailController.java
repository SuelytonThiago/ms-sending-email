package com.ms.email.rest.controller;

import com.ms.email.rabbitmq.contants.RabbitMQConstants;
import com.ms.email.rest.services.RabbitMQService;
import com.ms.email.rest.dto.EmailRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {

   @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("sendingEmail")
    @Operation(summary = "send an email")
    public ResponseEntity sendingEmail(@RequestBody @Valid EmailRequestDto emailRequestDto){
        this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_EMAIL,emailRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
