package kz.iitu.springdatademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/Home")
    public String getHomePage(Model model){
        model.addAttribute("greeting", "Hello");
        return "Home";
    }
}