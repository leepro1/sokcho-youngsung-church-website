package com.sokchoys.domain.info.entity;

import jakarta.annotation.Resource;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    @Column(length = 500)
    private String address;

    @Column(length = 2000)
    private String history;

    @Column(length = 2000)
    private String vision;

    @Builder
    public Info(String name, String address, String history, String vision) {
        this.name = name;
        this.address = address;
        this.history = history;
        this.vision = vision;
    }
}
