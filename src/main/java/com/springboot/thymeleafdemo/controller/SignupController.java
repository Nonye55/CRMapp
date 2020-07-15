package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Customer;
import com.springboot.thymeleafdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final CustomerService customerService;

    public SignupController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String signupView(){
        return "signup";
    }
    @PostMapping()
    public String signupCustomer(@ModelAttribute Customer customer , Model model){
        String signupError = null;

        if(!customerService.isUsernameAvailable(customer.getUserName())){
            signupError = "The username already exist";

        }
        if(signupError == null){
            int rowsAdded = customerService.createCustomer(customer);
            if(rowsAdded < 0){
                signupError = "There was an error signing you up,please try agian";

            }
        }
        if(signupError == null){
            model.addAttribute("signSuccess",true);
        }else{
            model.addAttribute("signup",signupError);
        }

        return "signup";
    }
}
