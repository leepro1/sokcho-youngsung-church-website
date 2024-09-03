package com.sokchoys.domain.info.controller;

import com.sokchoys.domain.info.entity.Info;
import com.sokchoys.domain.info.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping
    public String getInfo(Model model) {
        Info info = infoService.getInfo((short) 1);
        model.addAttribute("info", info);
        return "info";
    }

    @GetMapping("/edit")
    public String editInfo(Model model) {
        Info info = infoService.getInfo((short) 1);
        model.addAttribute("info", info);
        return "info-edit";
    }

    @PostMapping("/edit")
    public String updateInfo(@ModelAttribute Info info) {
        infoService.saveInfo(info);
        return "redirect:/info";
    }
}
