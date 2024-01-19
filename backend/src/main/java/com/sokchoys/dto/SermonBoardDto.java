package com.sokchoys.dto;

import com.sokchoys.constant.SermonType;
import com.sokchoys.entity.Sermon;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SermonBoardDto {

    private Long id;

    @NotBlank(message = "설교자는 필수 입력 값입니다.")
    private String preacher;

    @NotBlank(message = "설교 제목은 필수 입력 값입니다.")
    private String title;

    @NotBlank(message = "성경 말씀은 필수 입력 값입니다.")
    private String bible;

    @NotBlank(message = "설교링크는 필수 입력 값입니다.")
    private String sermonUrl;

    @NotBlank(message = "설교날짜는 필수 입력 값입니다.")
    private LocalDate sermonDate;

    @NotBlank(message = "설교타입은 필수 입력 값입니다.")
    private SermonType sermonType;

    public static SermonBoardDto toSermonBoardDto(Sermon sermon) {
        SermonBoardDto sermonBoardDto = new SermonBoardDto();
        sermonBoardDto.setId(sermon.getId());
        sermonBoardDto.setPreacher(sermon.getPreacher());
        sermonBoardDto.setTitle(sermon.getTitle());
        sermonBoardDto.setBible(sermon.getBible());
        sermonBoardDto.setSermonUrl(sermon.getSermonUrl());
        sermonBoardDto.setSermonDate(sermon.getSermonDate());
        //sermonBoardDto.getSermonType(sermon.getSermonType());

        return sermonBoardDto;
    }
}
