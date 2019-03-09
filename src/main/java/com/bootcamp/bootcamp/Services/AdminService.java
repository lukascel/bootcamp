package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Controllers.TrainersController;
import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    TrainerRepository trainerRepository;

    public void saveTrainer(Trainers trainer){
        trainerRepository.save(trainer);
    }

    public void removeTrainer(long id){
        trainerRepository.deleteById(id);
    }

//    public Optional<Trainers> getTreiner(long id){
//        Optional<Trainers> trainers = trainerRepository.findById(id);
//        return trainers;}

}
