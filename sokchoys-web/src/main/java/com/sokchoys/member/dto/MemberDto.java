package com.sokchoys.member.dto;

import com.sokchoys.member.constant.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private int id;
    private String email;
    private String password;
    private String name;
    private Role role;
    private String createAt;

}
