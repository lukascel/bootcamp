package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Models.User;
import com.bootcamp.bootcamp.Services.CourseModeService;
import com.bootcamp.bootcamp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

@Autowired
    private UserService userService;
private CourseModeService courseModeService;

    @GetMapping("/kursy/zapisz-uzytkownika-do-bazy")
        public String addUserToDB(Model model){
        model.addAttribute("user", new User());
        return "user_add";
    }

    @PostMapping("/kursy/dodaj-uzytkownika-do-kursu")
    public String addNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "user_add";
        }
        userService.saveUser(user);
        model.addAttribute("isSentUser", true);
        model.addAttribute("courses", courseModeService.getAllModes());
//        model.addAttribute("users", userService.getAllUsers());
        return "editions_available";
    }

}
