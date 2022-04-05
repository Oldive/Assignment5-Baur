package kz.iitu.springdatademo.controller;

import kz.iitu.springdatademo.service.CustomerService;
import kz.iitu.springdatademo.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }


  @GetMapping
  public String getCustomer(Model model){
    model.addAttribute("allCustomers", customerService.getCustomer());
    return "Customer";
  }

  @PostMapping
  public String registerCustomer(@ModelAttribute Customer customer, Model model){
    customerService.createCustomer(customer);
    model.addAttribute("allCustomers", customerService.getCustomer());
    return "redirect:Customer";
  }
}
