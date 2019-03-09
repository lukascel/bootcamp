package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainersService{

    @Autowired
    private TrainerRepository trainerRepository;


public List<Trainers> getAllTrainers(){
    List<Trainers> trainersList = trainerRepository.findAll();
    return trainersList;
}

    public List<Trainers> getOrderedAllTrainers(){
        List<Trainers> trainersOrderedList = trainerRepository.findAllByOrderByLastName();
    return trainersOrderedList;
}

//        List<Trainers> trainersList = new LinkedList<>();
//        Trainers trainer1 = new Trainers();
//        trainer1.setId(1);
//        trainer1.setFirstName("Adam");
//        trainer1.setLastName("Nowak");
//        trainer1.setSalary(100);
//
//        Trainers trainer2 = new Trainers();
//        trainer2.setId(2);
//        trainer2.setFirstName("Krzysztof");
//        trainer2.setLastName("Kowalski");
//        trainer2.setSalary(300);
//
//        Trainers trainer3 = new Trainers();
//        trainer3.setId(3);
//        trainer3.setFirstName("Anna");
//        trainer3.setLastName("Nowakowska");
//        trainer3.setSalary(500);
//
//        trainersList.add(trainer1);
//        trainersList.add(trainer2);
//        trainersList.add(trainer3);
//


public Optional<Trainers> getTreiner(long id){
    Optional<Trainers> trainers = trainerRepository.findById(id);
            return trainers;
    }

}



















