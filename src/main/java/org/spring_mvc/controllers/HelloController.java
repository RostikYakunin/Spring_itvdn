package org.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping (value = "/hello")
    public String hello () {
        return "WEB-INF/jsps/1.jsp";
    }
}
