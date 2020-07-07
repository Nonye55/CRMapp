package com.springboot.thymeleafdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailServiceImplTest {
   @Autowired
 EmailService emailService;
@Test
    void sendSimplemassage() {
        emailService.sendSimpleMessage("uka29c@gmail.com", "registration", "String text");



    }

}