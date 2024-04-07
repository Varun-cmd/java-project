package org.example.rest.controller;

import org.example.rest.hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class web {

    @GetMapping(path="/hello/{name}")
    public hello hellos(@PathVariable String name){
        return new hello("hello"+name);
    }
}
