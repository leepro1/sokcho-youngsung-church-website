package com.sokchoys.domain.notice.dto.response;

import com.sokchoys.domain.notice.entity.Notice;
import lombok.Builder;

@Builder
public record NoticeResponse(
    Long id,
    String title,
    String content,
    String author,
    String createdAt
) {

    public static NoticeResponse of(Notice notice) {
        return NoticeResponse.builder()
            .id(notice.getId())
            .title(notice.getTitle())
            .content(notice.getContent())
            .author(notice.getAuthor())
            .createdAt(notice.getCreatedAt().toString())
            .build();
    }
}
