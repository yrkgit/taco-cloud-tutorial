package com.example.tacocloudtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller            // <1>
public class HomeController {

//    @RequestMapping("/")     // <2>
//    public String home() {
//        return "home";     // <3>
//    }
    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
