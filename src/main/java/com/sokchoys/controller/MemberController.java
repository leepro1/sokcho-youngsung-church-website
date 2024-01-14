package com.sokchoys.controller;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "members/memberForm";
    }

    @PostMapping("/members")
    public String memberForm(MemberFormDto memberFormDto) {
        memberService.saveMember(memberFormDto);
        return "redirect:/";
    }

    @GetMapping("/admin/members")
    public String members(Model model) {
        List<MemberFormDto> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);

        return "members/memberList";
    }

    @GetMapping("/admin/members/{id}")
    public String findMember(@PathVariable Long id, Model model){
        MemberFormDto member = memberService.findOne(id);
        model.addAttribute("member",member);

        return "members/memberDetail";
    }

    @DeleteMapping("/admin/members/{id}")
    public String deleteMember(@PathVariable Long id){
        memberService.deleteById(id);
        return "redirect:/";
    }
}
