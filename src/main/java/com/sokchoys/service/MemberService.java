package com.sokchoys.service;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.entity.Member;
import com.sokchoys.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberFormDto memberFormDto){
        Member member = Member.createMember(memberFormDto);
        Member savedMember = memberRepository.save(member);
    }


}
