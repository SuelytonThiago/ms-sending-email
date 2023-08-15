package com.ms.email.rest.services;

import com.ms.email.domain.entities.Emails;
import com.ms.email.domain.enums.StatusEmail;
import com.ms.email.domain.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PasswordEncoder encoder;

    public Emails sendEmail(Emails emails){
        emails.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emails.getEmailFrom());
            message.setTo(emails.getEmailTo());
            message.setSubject(emails.getSubject());
            message.setText(emails.getText());
            javaMailSender.send(message);

            emails.setStatusEmail(StatusEmail.SEND);
            emails.setEmailFrom(encoder.encode(emails.getEmailFrom()));
            emails.setEmailTo(encoder.encode(emails.getEmailTo()));
        }
        catch(MailException e){
            emails.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            return emailRepository.save(emails);
        }
    }

}
