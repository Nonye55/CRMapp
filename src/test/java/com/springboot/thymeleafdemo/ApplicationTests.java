package com.springboot.thymeleafdemo;

import com.springboot.thymeleafdemo.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {


	@Autowired
	EmailService emailService;

	@Test
	void contextLoads() {

		assertNotNull(emailService);
	}


	@Test
	void sendText(){

	}




}
