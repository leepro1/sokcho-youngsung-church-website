package com.sokchoys.member.service;

import com.sokchoys.member.dto.MemberDto;
import com.sokchoys.member.dto.MemberFormDto;
import com.sokchoys.member.dto.MemberInfoDto;

import java.util.List;

public interface MemberService {
    MemberDto findById(int id);

    List<MemberDto> findAll();

    void createMember(MemberFormDto member);

    // void updatePassword(MemberPwdDto memberPwdDto);

    void deleteById(int id);

    MemberInfoDto login(String email, String password);
}
