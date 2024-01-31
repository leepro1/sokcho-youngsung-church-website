package com.sokchoys.service;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.dto.MemberResultDto;

public interface MemberService {

    MemberResultDto saveMember(MemberFormDto memberFormDto);

    MemberResultDto findAll();

    MemberResultDto findOne(Long id);

    MemberResultDto updateMember(MemberFormDto memberFormDto);

    MemberResultDto deleteMember(Long id);
}
