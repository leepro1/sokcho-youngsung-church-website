package com.sokchoys.entity;

import com.sokchoys.constant.Role;
import com.sokchoys.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String username;

    private String sex;

    private Boolean isChurchMember; //속초영성교회 등록 교인 여부

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public static Member createMember(MemberFormDto memberFormDto) {
        Member member = new Member();
        member.setEmail(memberFormDto.getEmail());
        member.setPassword(memberFormDto.getPassword());
        member.setUsername(memberFormDto.getUsername());
        member.setSex(memberFormDto.getSex());
        member.setIsChurchMember(memberFormDto.getIsChurchMember());
        member.setRole(Role.USER);
        member.setCreatedTime(LocalDateTime.now());
        member.setUpdatedTime(LocalDateTime.now());

        return member;
    }

    public void toUpdateMember(MemberFormDto memberFormDto){
        this.setPassword(memberFormDto.getPassword());
        this.setUsername(memberFormDto.getUsername());
        this.setSex(memberFormDto.getSex());
        this.setIsChurchMember(memberFormDto.getIsChurchMember());
        this.setUpdatedTime(LocalDateTime.now());
    }
}
