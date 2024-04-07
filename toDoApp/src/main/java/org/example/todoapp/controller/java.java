package org.example.todoapp.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class java {

    @RequestMapping("hello")
    @ResponseBody
    public String sayhello(){
        return "hello";
    }
}
