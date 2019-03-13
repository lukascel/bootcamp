package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.Mode;
import com.bootcamp.bootcamp.Repository.CourseModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseModeService {

    @Autowired
    CourseModeRepository courseModeRepository;

    public List<Mode> getAllModes(){
        List<Mode> modeList = courseModeRepository.findAll();
        return modeList;
    }

    public void SaveMode(Mode mode){
        courseModeRepository.save(mode);
    }

    public Optional<Mode> getMode(long id){
        Optional<Mode> mode = courseModeRepository.findById(id);
        return mode;
    }

}
