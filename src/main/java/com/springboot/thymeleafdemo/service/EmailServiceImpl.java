package com.springboot.thymeleafdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;



    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(to);
                message.setSubject(subject);
                message.setText(text);
                emailSender.send(message);
    }

//    @Override
//    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
//
//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper  = new MimeMessageHelper (message,true);
//        helper.setTo(to);
//        helper.setsubject(subject);
//        helper.settext(text);
//
//        FileSystemResource file
//                = new FileSystemResource(new File(pathToAttachment));
//        helper.addAttachment("Invoice", file);
//
//        emailSender.send(mesage);
//
//
//
//
//    }



}

