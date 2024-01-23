package com.sokchoys;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:8800")
    public String index() {
        return "Hello World";
    }
}
