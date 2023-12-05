package com.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// M-V-C // model, view, controller

@Controller
public class HelloController {

    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello world and welcome to spring mvc");
        return "hello_world";
    }
}
