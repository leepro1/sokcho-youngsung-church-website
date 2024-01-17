package com.sokchoys.service;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.entity.Member;
import com.sokchoys.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberFormDto memberFormDto) {
        Member member = Member.createMember(memberFormDto);
        Member savedMember = memberRepository.save(member);
    }

    public List<MemberFormDto> findAll() {
        List<Member> memberEntityList = memberRepository.findAll();
        List<MemberFormDto> memberFormDtoList = new ArrayList<>();

        for (Member member : memberEntityList) {
            memberFormDtoList.add(MemberFormDto.toMemberFormDto(member));
        }

        return memberFormDtoList;
    }

    public MemberFormDto findOne(Long id) {
        Member member = memberRepository.findById(id).get();
        return MemberFormDto.toMemberFormDto(member);
    }

    public MemberFormDto updateMember(MemberFormDto memberFormDto) {
        Member foundMember = memberRepository.findById(memberFormDto.getId()).get();
        foundMember.toUpdateMember(memberFormDto);
        return MemberFormDto.toMemberFormDto(memberRepository.save(foundMember));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
