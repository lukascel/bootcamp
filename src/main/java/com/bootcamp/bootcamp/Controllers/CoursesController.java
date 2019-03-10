package com.bootcamp.bootcamp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesController {

    @GetMapping("/kursy")
    public String getCourses(){
        return "courses";
    }
}
