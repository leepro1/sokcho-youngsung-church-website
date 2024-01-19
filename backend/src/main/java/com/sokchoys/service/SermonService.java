package com.sokchoys.service;

import com.sokchoys.dto.SermonBoardDto;
import com.sokchoys.entity.Sermon;
import com.sokchoys.repository.SermonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SermonService {

    private final SermonRepository sermonRepository;

    public void saveSermon(SermonBoardDto sermonBoardDto){
        Sermon sermon = Sermon.createSermon(sermonBoardDto);
        Sermon savedSermon = sermonRepository.save(sermon);
    }

//    public List<SermonBoardDto> findAll(){
//        List<Sermon> sermonEntityList = sermonRepository.findAll();
//        List<SermonBoardDto> sermonBoardDtoList = new ArrayList<>();
//
//        for(Sermon sermon : sermonEntityList){
//            sermonBoardDtoList.add()
//        }
//    }
}
