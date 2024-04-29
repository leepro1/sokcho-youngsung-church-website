package com.sokchoys.member.dto;

import com.sokchoys.member.constant.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

    private String email;
    private String password;
    private String name;
    private Role role;

    public MemberFormDto() {
        this.role = Role.USER;
    }
}
