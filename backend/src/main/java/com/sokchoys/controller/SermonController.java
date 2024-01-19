package com.sokchoys.controller;

import com.sokchoys.dto.SermonBoardDto;
import com.sokchoys.service.SermonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sermons")
@Controller
public class SermonController {

    private final SermonService sermonService;

//    @GetMapping("/new")
//    public


//    @GetMapping
//    public String sermons(Model model){
//        List<SermonBoardDto> sermonList = sermonService.findAll();
//        model.addAttribute("sermonList",sermonList);
//    }
}
