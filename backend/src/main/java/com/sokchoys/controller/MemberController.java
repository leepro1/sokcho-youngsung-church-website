package com.sokchoys.controller;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.dto.MemberResultDto;
import com.sokchoys.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8800")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    // thymeleaf -> Vue 수정 필요
    @GetMapping("/members")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "members/memberForm";
    }

    @PostMapping("/members")
    public MemberResultDto memberForm(@RequestBody MemberFormDto memberFormDto) {
        return memberService.saveMember(memberFormDto);
    }

    @GetMapping("/admin/members")
    public MemberResultDto findMembers() {
        return memberService.findAll();
    }

    @GetMapping("/members/{id}")
    public MemberResultDto findMember(@PathVariable Long id) {
        return memberService.findOne(id);
    }

    @PutMapping("/members/{id}")
    public MemberResultDto updateMember(@PathVariable Long id, @RequestBody MemberFormDto memberFormDto) {
        return memberService.updateMember(memberFormDto);
    }

    @DeleteMapping("/members/{id}")
    public MemberResultDto deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }
}
