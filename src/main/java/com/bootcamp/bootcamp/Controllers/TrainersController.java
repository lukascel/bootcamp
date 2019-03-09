package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/trenerzy")
public class TrainersController {

    //utworzenie obiektu trainerService w Springu. Wstrzykuje obiekt do modelu, dlatego nie musze poniżej tego obiektu tworzyć
    @Autowired
    private TrainersService trainersService; //zeby tutaj wstrzyknąć dane z Controllera to muszę w trainersService miec że to jest serwis

    @GetMapping("")
    public String trainers(Model model){

        model.addAttribute("trainersList", trainersService.getAllTrainers());

        //System.out.println(trainersService.getAllTrainers());
        return "trainers";
    }

    @GetMapping("{nazwaParametru}")
    public String showTrainer(@PathVariable("nazwaParametru") int id, //pathVariable - działa jak RequestParam, tyle że pozwala przejąć parametr ze ścieżki
                                Model model) {

        Optional<Trainers> trainers = trainersService.getTreiner(id);
        if(trainers.isPresent()){
            model.addAttribute("trainer", trainers.get()); //trainers.get - wyjmuje coś z optional'a
            return "trainer_details";
        } else{
            return "redirect:"; //wbudowany w Springu, "zmienia adres", "Forward nie zmienia adresu" (wczorajsze zajęcia)!!
        }
    }





}
