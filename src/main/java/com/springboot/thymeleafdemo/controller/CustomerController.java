package com.springboot.thymeleafdemo.controller;

import javax.servlet.http.HttpServletRequest;

import com.springboot.thymeleafdemo.entity.EmailDTO;
import com.springboot.thymeleafdemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.springboot.thymeleafdemo.entity.Customer;
import com.springboot.thymeleafdemo.repository.CustomerRepository;

import java.util.logging.Logger;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	Logger logger = Logger.getLogger(getClass().getName());
	private final CustomerRepository customerRepository;

	@Autowired
	EmailService emailService;
	
	@Autowired
	public CustomerController(CustomerRepository customerRepositroy) {
		this.customerRepository = customerRepositroy ;
	}
	
	@GetMapping("signup")
	public String showSignupForm(Customer customer ) {
//		customerRepository.save(customer);
//		model.addAttribute("customers",customerRepository.findAll());
		return "add-customer";
	}
	@GetMapping ("list")
	public String showUdateForm(Model model) {
		model.addAttribute("customers",customerRepository.findAll());
		
		return"index";
	}
	@PostMapping("addnew")
	public String addnewCustomer(@Validated Customer customer,BindingResult result,Model model, HttpServletRequest request ) {
		if(result.hasErrors()) {
			return "add-customer";
		  }
		else {
			Customer verified = customerRepository.save(customer);
//			eventPublisher.publishEvent(new VerificationToken(request.getContextPath(), null, null, verified, null));
		}
		    return"redirect:/customer/list";
	}
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id,Model model) {
			Customer customer = customerRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id));
	
			model.addAttribute("customer",customer);
	
				return"update-customer";
	 		
	 	}
	@PostMapping("update/{id}")
	public String UpdateCustomer(@PathVariable("id") long id,@Validated Customer customer,BindingResult result, Model model) {
		if(result.hasErrors()) {
			customer.setId(id);
			System.out.println("Errors");
				return "update-customer";
		}
	
	customerRepository.save(customer);
	     return "redirect:/customer/list";
	}

	@GetMapping("delete/{id}")
	public String showUpdateform(@PathVariable("id") long id,Model model){
		
		Customer customer = customerRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid id:" + id));
		
		customerRepository.delete(customer);
		model.addAttribute("customer", customerRepository.findAll());
		
		      return "redirect:/customer/list";
	
}


	@GetMapping("email")
	public String renderEmailForm(Model model ){

		model.addAttribute("emailObj", new EmailDTO());

		return "email";

	}

	@PostMapping("sendmail")
	public String sendmail(@ModelAttribute("emailObj") EmailDTO emailDTO){

			logger.info(emailDTO.toString());
		if (emailDTO.getMessage() == null || emailDTO.getReceiver() == null || emailDTO.getSubject() == null) {
			return "email";
		}
		else {
			emailService.sendSimpleMessage(emailDTO.getReceiver(), emailDTO.getSubject(), emailDTO.getMessage());
		}

		return "index";
	}



	
}
