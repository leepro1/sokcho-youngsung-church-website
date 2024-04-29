package com.sokchoys.member.controller;

import com.sokchoys.member.dto.MemberDto;
import com.sokchoys.member.dto.MemberFormDto;
import com.sokchoys.member.dto.MemberInfoDto;
import com.sokchoys.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ExceptionHandler(Exception.class)
    public String handler(Exception ex, Model model) {
        model.addAttribute("msg", ex.getMessage());

        return "/members/login";
    }

    @GetMapping("/login")
    public String login(){
        return "members/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        MemberInfoDto member = memberService.login(email,password);
        session.setAttribute("userInfo", member);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/join")
    public String join(){
        return "members/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberFormDto member){
        memberService.createMember(member);
        return "redirect:/members/login";
    }

    @GetMapping("/mypage")
    public String detail(HttpSession session){
        return "members/mypage";
    }

}
