package me.moosecanswim.memegenerator.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String homePage(){
        return"homepage";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
