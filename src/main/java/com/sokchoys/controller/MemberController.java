package com.sokchoys.controller;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "members/memberForm";
    }

    @PostMapping("/new")
    public String memberForm(MemberFormDto memberFormDto) {
        memberService.saveMember(memberFormDto);
        return "redirect:/";
    }

    @GetMapping
    public String members(Model model) {
        List<MemberFormDto> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);

        return "members/memberList";
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteById(id);
    }
}
