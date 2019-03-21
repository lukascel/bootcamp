package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Models.CourseEdition;
import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Models.User;
import com.bootcamp.bootcamp.Services.CourseEditionService;
import com.bootcamp.bootcamp.Services.CourseModeService;
import com.bootcamp.bootcamp.Services.CourseService;
import com.bootcamp.bootcamp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseModeService courseModeService;

    @Autowired
    private CourseEdition courseEdition;

    @Autowired
    private CourseEditionService courseEditionService;


    @GetMapping("/kursy/zapisz-uzytkownika-do-bazy/{id}")
    public String addUserToDB(@PathVariable long id, Model model) {

        CourseEdition courseEdition = courseEditionService.getActiveCourseEdition(id);

        if(courseEdition == null) {
            model.addAttribute("editionClosed", true);
        }else{
                model.addAttribute("edition", courseEdition);
                model.addAttribute("user", User.builder().build());
        }
//jesli nie mam powyższego, czyli nie uwzględniam zabezpieczenia ze ktoś z palca wpisze mi id w pasku wyszukiwania
//
//        model.addAttribute("user", new User());
//        model.addAttribute("edition", courseEditionService.getCourseEdition(id).get());
        return "user_add";
    }

    @PostMapping("/kursy/dodaj-uzytkownika-do-kursu/{id}")
    public String addNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult,
                             @PathVariable long id, Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            model.addAttribute("edition", courseEditionService.getCourseEdition(id).get());
            return "user_add";
        }
        userService.saveUser(user);
        model.addAttribute("isSentUser", true);
        model.addAttribute("edition", courseEditionService.getCourseEdition(id).get());
        model.addAttribute("user", User.builder().build());

        return "editions_available";
    }

    @GetMapping("/user")
    public String panel(Model model) {
//        model.addAttribute("edition", courseEditionService.
        return "user_main";
    }

}
