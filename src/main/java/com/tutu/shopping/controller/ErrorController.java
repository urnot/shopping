package com.tutu.shopping.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @RequestMapping(value = "/error")
    public String error(){
        return "error";
    }
}
