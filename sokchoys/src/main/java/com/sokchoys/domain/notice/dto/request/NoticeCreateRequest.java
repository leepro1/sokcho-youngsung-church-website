package com.sokchoys.domain.notice.dto.request;

import lombok.Builder;

public record NoticeCreateRequest(
    String title,
    String content,
    String author
) {
    
}
