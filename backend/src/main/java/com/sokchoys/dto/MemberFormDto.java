package com.sokchoys.dto;

import com.sokchoys.constant.Role;
import com.sokchoys.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberFormDto {

    private Long id;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String username;

    @NotBlank(message = "성별은 필수 입력 값입니다.")
    private String sex;

    @NotBlank(message = "등록 여부는 필수 입력 값입니다.")
    private Boolean isChurchMember; //속초영성교회 등록 교인 여부

    private Role role;

    private LocalDateTime createdTime;

    public static MemberFormDto toMemberFormDto(Member member) {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setId(member.getId());
        memberFormDto.setEmail(member.getEmail());
        memberFormDto.setPassword(member.getPassword());
        memberFormDto.setUsername(member.getUsername());
        memberFormDto.setSex(member.getSex());
        memberFormDto.setIsChurchMember(member.getIsChurchMember());
        memberFormDto.setRole(member.getRole());
        memberFormDto.setCreatedTime(member.getCreatedTime());

        return memberFormDto;
    }
}
