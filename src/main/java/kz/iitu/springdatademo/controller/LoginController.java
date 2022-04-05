package kz.iitu.springdatademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import kz.iitu.springdatademo.entity.Customer;
import kz.iitu.springdatademo.service.CustomerService;

@Controller
@RequestMapping("/Login")
public class LoginController {

    private CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getLoginPage() {
        return "Login";
    }
    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {

        Customer matchingCustomer = customerService.checkPin(customer);


        if (matchingCustomer != null) {
            model.addAttribute("greeting",
                    "Welcome, " + matchingCustomer.getName());
        } else {
            model.addAttribute("greeting", "Can't find customer");
        }
        return "Home";
    }
}