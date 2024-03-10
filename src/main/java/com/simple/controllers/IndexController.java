
package com.simple.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class IndexController {

    @GetMapping("")
    public String index() {
        return "Atividade Spring Boot!";
    }

}
