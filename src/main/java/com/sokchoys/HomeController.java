package com.sokchoys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("welcomeMessage", "안녕하세요 속초영성교회입니다.");

        return "index";
    }
}
