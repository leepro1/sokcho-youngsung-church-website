package com.sokchoys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResultDto {

    private Boolean state;
    private Object result; // Collection 까지 받기 위함
    private String message;

}
