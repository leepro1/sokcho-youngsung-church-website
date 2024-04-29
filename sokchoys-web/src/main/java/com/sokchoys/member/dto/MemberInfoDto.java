package com.sokchoys.member.dto;

import com.sokchoys.member.constant.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberInfoDto {

    private String email;
    private String name;
    private Role role;
}
