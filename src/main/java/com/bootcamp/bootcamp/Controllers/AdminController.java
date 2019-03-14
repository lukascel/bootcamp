package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Models.Course;
import com.bootcamp.bootcamp.Models.CourseEdition;
import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Repository.CourseModeRepository;
import com.bootcamp.bootcamp.Services.CourseEditionService;
import com.bootcamp.bootcamp.Services.CourseModeService;
import com.bootcamp.bootcamp.Services.CourseService;
import com.bootcamp.bootcamp.Services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TrainersService trainersService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseEditionService courseEditionService;
    @Autowired
    private CourseModeService courseModeService;


    @GetMapping("")
    public String admin(@RequestParam(name = "imie", defaultValue = "Łukasz", required = false) String firstName,
                        @RequestParam(name = "nazwisko", defaultValue = "Celej", required = false) String lastName,
                        Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "admin";
    }


//    @GetMapping("/admin/trenerzyadmin")
//    public String trainersAdmin(){
//        return "trainers_admin";}

    @GetMapping("/trenerzyadmin")
    public String adminShowTrainers(Model model) {
        model.addAttribute("trainersList", trainersService.getOrderedAllTrainers());
        return "trainers_admin";
    }

    @GetMapping("/dodaj-trenera-do-bazy")
    public String addTrainerToDB(Model model) {
        model.addAttribute("trainer", new Trainers());
        return "trainers_admin_add";
    }

    @PostMapping("/dodaj_trenera")
    public String addNewTrainer(@Valid @ModelAttribute(name = "trainer") Trainers trainer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            // model.addAttribute("trainer", trainer);
            return "trainers_admin_add";
        }
        trainersService.saveTrainer(trainer);
        model.addAttribute("isSentTrainer", true);
//        model.addAttribute("trainer", new Trainers());
        model.addAttribute("trainerListOrdered", trainersService.getOrderedAllTrainers());
        return "trainers_admin";
    }

    @GetMapping("/usun-trenera/{id}")
    public String removeTrainer(@PathVariable long id, Model model) {
        trainersService.removeTrainer(id);
        model.addAttribute("isRemoved", true);
        model.addAttribute("trainersList", trainersService.getOrderedAllTrainers());
        return "trainers_admin";
    }

    @GetMapping("edytuj-trenera/{id}")
    public String editTrainer(@PathVariable long id, Model model) {
        Optional<Trainers> trainer = trainersService.getTreiner(id);
        model.addAttribute("trainer", trainer.get());
        return "trainers_admin_add";
    }


    @GetMapping("/courseadmin")
    public String adminShowCourse(Model model) {
        model.addAttribute("courseList", courseService.getAllCourses());
        return "course_admin";
    }

    @GetMapping("/dodaj-kurs-do-bazy")
    public String addCoursetoDB(Model model) {
        model.addAttribute("course", new Course());
        return "course_admin_add";
    }

    @PostMapping("/dodaj_kurs")
    public String addNewCourse(@Valid @ModelAttribute Course course, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "course_admin_add";
        }
        courseService.saveCourse(course);
        model.addAttribute("isSentCourse", true);
        model.addAttribute("courseList", courseService.getAllCourses());
        return "course_admin";
    }

    @GetMapping("edytuj-kurs/{id}")
    public String editCourse(@PathVariable long id, Model model) {
        Optional<Course> course = courseService.getCourse(id);
        model.addAttribute("course", course.get());
        return "course_admin_add";
    }


    @GetMapping("/edycja")
    public String adminShowEdition(Model model) {
        model.addAttribute("editionList", courseEditionService.getAllEditions());
        return "edition_admin";
    }

    @GetMapping("/dodaj-edycje-kursu-do-bazy")
    public String addCourseEditionToDB(Model model) {
        model.addAttribute("courseEdition", new CourseEdition());
        model.addAttribute("courses", courseService.getAllCourses());
        //model.addAttribute("mode", courseEditionService.getAllEditions());
        model.addAttribute("mode", courseModeService.getAllModes());
        model.addAttribute("trener", trainersService.getAllTrainers());
        return "edition_admin_add";
    }

    @PostMapping("/dodaj_edycje_kursu")
    public String addNewEditionCourse(@Valid @ModelAttribute CourseEdition courseEdition, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "edition_admin_add";
        }
        courseEditionService.saveCourseEdition(courseEdition);
        model.addAttribute("isSentCourseEdition", true);
        model.addAttribute("editionList", courseEditionService.getAllEditions());
        return "edition_admin";
    }

    @GetMapping("edytuj-edycje/{id}")
    public String editEdition(@PathVariable long id, Model model) {
        Optional<CourseEdition> courseEdition = courseEditionService.getCourseEdition(id);
        model.addAttribute("courseEdition", courseEdition.get());
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("mode", courseModeService.getAllModes());
        model.addAttribute("trener", trainersService.getAllTrainers());
        return "edition_admin_add";
    }
}