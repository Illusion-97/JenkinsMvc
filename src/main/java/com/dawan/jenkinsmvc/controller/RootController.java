package com.dawan.jenkinsmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Root controller.
 */
@Controller
public class RootController {
    /**
     * Index string.
     *
     * @return the string
     */
    @GetMapping()
    public String index() {
        //throw new RuntimeException("Fail voluntarily");
        return "index";
    }
}
