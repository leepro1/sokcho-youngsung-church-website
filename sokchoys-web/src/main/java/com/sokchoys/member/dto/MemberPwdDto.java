package com.sokchoys.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberPwdDto {

    private String email;
    private String newPwd;
}
