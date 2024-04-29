package com.sokchoys;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SokchoException extends RuntimeException {
    public SokchoException(String msg){
        super(msg);
    }
}
