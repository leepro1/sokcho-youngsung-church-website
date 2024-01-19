package com.sokchoys.entity;

import com.sokchoys.constant.SermonType;
import com.sokchoys.dto.SermonBoardDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sermon")
public class Sermon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String preacher;

    private String title;

    private String bible;

    private String sermonUrl;

    private LocalDate sermonDate;

    @Enumerated(EnumType.STRING)
    private SermonType sermonType;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public static Sermon createSermon(SermonBoardDto sermonBoardDto) {
        Sermon sermon = new Sermon();
        sermon.setPreacher(sermonBoardDto.getPreacher());
        sermon.setTitle(sermonBoardDto.getTitle());
        sermon.setBible(sermonBoardDto.getBible());
        sermon.setSermonUrl(sermonBoardDto.getSermonUrl());
        sermon.setSermonType(sermonBoardDto.getSermonType());
        sermon.setSermonDate(sermonBoardDto.getSermonDate());
        sermon.setCreatedTime(LocalDateTime.now());
        sermon.setUpdatedTime(LocalDateTime.now());

        return sermon;
    }
}
