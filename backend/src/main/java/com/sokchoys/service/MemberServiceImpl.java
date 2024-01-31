package com.sokchoys.service;

import com.sokchoys.dto.MemberFormDto;
import com.sokchoys.dto.MemberResultDto;
import com.sokchoys.entity.Member;
import com.sokchoys.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private MemberResultDto memberResultDto;

    public MemberResultDto saveMember(MemberFormDto memberFormDto) {
        memberResultDto = new MemberResultDto();
        Optional<Member> optionalMember = memberRepository.findByEmail(memberFormDto.getEmail());

        if (optionalMember.isEmpty()) {
            Member savedMember = memberRepository.save(Member.createMember(memberFormDto));
            memberResultDto.setState(true);
            memberResultDto.setResult(MemberFormDto.toMemberFormDto(savedMember));
            memberResultDto.setMessage("멤버 등록을 성공하였습니다.");
        } else {
            memberResultDto.setState(false);
            memberResultDto.setMessage("멤버 등록을 실패하였습니다.");
        }

        return memberResultDto;
    }

    public MemberResultDto findAll() {
        memberResultDto = new MemberResultDto();
        List<Member> memberEntityList = memberRepository.findAll();

        if (!memberEntityList.isEmpty()) {
            List<MemberFormDto> memberFormDtoList = new ArrayList<>();

            for (Member member : memberEntityList) {
                memberFormDtoList.add(MemberFormDto.toMemberFormDto(member));
            }
            memberResultDto.setState(true);
            memberResultDto.setResult(memberFormDtoList);
            memberResultDto.setMessage("전체 멤버 조회를 성공하였습니다.");
        } else {
            memberResultDto.setState(false);
            memberResultDto.setMessage("전체 멤버 조회를 실패하였습니다.");
        }

        return memberResultDto;
    }

    public MemberResultDto findOne(Long id) {
        memberResultDto = new MemberResultDto();
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isPresent()) {
            memberResultDto.setState(true);
            memberResultDto.setResult(
                    MemberFormDto.toMemberFormDto(optionalMember.get()));
            memberResultDto.setMessage("멤버 조회를 성공하였습니다.");
        } else {
            memberResultDto.setState(false);
            memberResultDto.setMessage("멤버 조회를 실패하였습니다.");
        }

        return memberResultDto;
    }

    public MemberResultDto updateMember(MemberFormDto memberFormDto) {
        memberResultDto = new MemberResultDto();
        Optional<Member> optionalMember = memberRepository.findById(memberFormDto.getId());

        if (optionalMember.isPresent()) {
            Member foundMember = optionalMember.get();
            foundMember.toUpdateMember(memberFormDto);
            MemberFormDto updateMemberDto = MemberFormDto.toMemberFormDto(memberRepository.save(foundMember));

            memberResultDto.setState(true);
            memberResultDto.setResult(updateMemberDto);
            memberResultDto.setMessage("멤버 수정을 성공하였습니다.");
        } else {
            memberResultDto.setState(false);
            memberResultDto.setMessage("멤버 수정을 실패하였습니다.");
        }
        return memberResultDto;
    }

    public MemberResultDto deleteMember(Long id) {
        memberResultDto = new MemberResultDto();
        memberRepository.deleteById(id);

        memberResultDto.setState(true);
        memberResultDto.setMessage("멤버 삭제를 성공하였습니다.");

        return memberResultDto;
    }
}
