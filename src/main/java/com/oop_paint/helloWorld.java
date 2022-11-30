package com.oop_paint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {
    @GetMapping("/hi")
    public String hi(){
        return "it is working";
    }
}
