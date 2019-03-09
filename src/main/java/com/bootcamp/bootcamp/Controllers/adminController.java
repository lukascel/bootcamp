package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Models.Contact;
import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Repository.TrainerRepository;
import com.bootcamp.bootcamp.Services.AdminService;
import com.bootcamp.bootcamp.Services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private TrainersService trainersService;
    @Autowired
    private AdminService adminService;

    @GetMapping("")
    public String admin(@RequestParam(name = "imie", defaultValue = "Łukasz", required = false) String firstName,
                        @RequestParam(name = "nazwisko", defaultValue = "Celej", required = false) String lastName,
                        Model model){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "admin";}


//    @GetMapping("/admin/trenerzyadmin")
//    public String trainersAdmin(){
//        return "trainers_admin";}

    @GetMapping("/trenerzyadmin")
    public String adminShowTrainers(Model model){
        model.addAttribute("trainersList", trainersService.getOrderedAllTrainers());
        return "trainers_admin";
    }

    @GetMapping("/dodaj-trenera-do-bazy")
    public String addTrainerToDB(Model model){
        model.addAttribute("trainer", new Trainers());
        return "trainers_admin_add";
    }

    @PostMapping("/dodaj_trenera")
    public String addNewTrainer(@ModelAttribute Trainers trainer, Model model){
        model.addAttribute("isSentTrainer", true);
        model.addAttribute("trainer", new Trainers());
        System.out.println(trainer);
        adminService.saveTrainer(trainer);
        return "trainers_admin";
    }

    @GetMapping("/usun-trenera/{id}")
            public String removeTrainer(@PathVariable long id, Model model){
        adminService.removeTrainer(id);
        model.addAttribute("isRemoved", true);
        model.addAttribute("trainersList", trainersService.getOrderedAllTrainers());
        return "trainers_admin";
    }

        @GetMapping("edytuj-trenera/{id}")
    public String editTrainer(@PathVariable long id, Model model){
            Optional<Trainers> trainer = trainersService.getTreiner(id);
            model.addAttribute("trainer", trainer.get());
            return "trainers_admin_add";
        }
}
