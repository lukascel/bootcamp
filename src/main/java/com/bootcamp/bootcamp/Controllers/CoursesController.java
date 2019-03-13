package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Services.CourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesController {
    @Autowired
    CourseEditionService courseEditionService;

    @GetMapping("/kursy")
    public String getCourses(Model model){
        model.addAttribute("courseEdition", courseEditionService.getAllEditions());
        return "editions_available";
    }
}
