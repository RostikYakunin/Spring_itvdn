package org.spring_mvc.controllers;

import org.spring_mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

    @GetMapping (value = "/bey")
    public String hello () {
        return "WEB-INF/jsps/bey.jsp";
    }

    @GetMapping (value = "/new")
    public String goGet () {
        return "WEB-INF/jsps/new.jsp";
    }

    @GetMapping (value = "/info-input")
    public String infoInput () {
        return "WEB-INF/jsps/info-add.jsp";
    }

    @PostMapping (value = "/info-input")
    public ModelAndView doPost (@ModelAttribute (value = "user") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("WEB-INF/jsps/summary.jsp");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
