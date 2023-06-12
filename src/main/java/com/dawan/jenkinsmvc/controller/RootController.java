package com.dawan.jenkinsmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping()
    public String index() {
        throw new RuntimeException("Fail voluntarily");
        //return "index";
    }
}
