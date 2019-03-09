package com.bootcamp.bootcamp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    //@RequestMapping(value = "o-nas", method = RequestMethod.GET)
    @GetMapping("o-nas") //uproszczenie - rozwinięcie jest zakomentowanej linijkę wyzej. Jest też POSTmapping
    public String getAbout(){
        return "about";
    }
}
