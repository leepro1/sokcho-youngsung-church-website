package com.sokchoys.domain.info.service;

import com.sokchoys.domain.info.entity.Info;
import com.sokchoys.domain.info.repository.InfoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final InfoRepository infoRepository;

    public Info getInfo(Short id) {
        return infoRepository.findById(id).orElse(createDefaultInfo());
    }

    public void saveInfo(Info info) {
        infoRepository.save(info);
    }

    public Optional<Info> findInfoById(Short id) {
        return infoRepository.findById(id);
    }

    private Info createDefaultInfo() {
        return Info.builder()
            .name("Default Name")
            .address("Default Address")
            .history("Default History")
            .vision("Default Vision")
            .build();
    }
}
