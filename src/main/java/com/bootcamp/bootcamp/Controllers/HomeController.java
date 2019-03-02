package com.bootcamp.bootcamp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //to jest "adnotacja" z prezentacji. Są takie w Stringu poprostu
//@RequestMapping(value = "/bootcamp", method = RequestMethod.GET) // - pozwala zrobić w adresie ten bootcamp - jakby stronę główną z której później bedziemy rozwidlać. Pozwala wynieść część wspólną adresu jakby przed nawias.

public class HomeController {

    //piszę pierwszą metodkę z oznaczeniem adnotacji Springowej:
    //@RequestMapping(value = "/", method = RequestMethod.GET) // ukośnik znaczy ze to jest strona główna
    @GetMapping("/")
   // żeby wyświetliło mi stronę internetową to potrzebuję zeby metoda zwracała mi string'a.
    public String getHome(@RequestParam(name = "imie", defaultValue = "Jan") String firstName, //default zrobi, że jesli nie podam imienia po pytajniku - doda default.
                          @RequestParam(name = "nazwisko", required = false) String lastName, // ten requestparam pozwala pobierać w pasku na stronie imie i w efekcie wyrzuca mi to imie na konsoli - to co mam w sout. /zeby pobierac dwa to w aresie podaje je z Ampersantem
                          @RequestParam (defaultValue = "40") int wiek,    //jeśli zmienna ma sie nazywac tak jak parametr to nie musze pisac tego co powyzej w nawiasie. Kiedy inne? Np. jak piszemy program dla polaków - zmienne po polsku ale program po angielsku - name i imie.
                          Model model){ //dodaje model bym mógł cokolwiek robić w html'u, zebym mógł sie z tym komunikować.
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        //System.out.println("Witaj " + firstName + " " + lastName + " " + wiek);
//        if (wiek>20) {
//                return "redirect:o-nas";  // jesli podaje wiek 30 to przekierun na stronę inną - często wykorzystywane dla weryfikacji, czy udała sie płatnośc.
//            }
        return "home";          // szuka pliku "home" w folderze templates.
    }

    //@RequestMapping(value = "o-nas", method = RequestMethod.GET)
    @GetMapping("o-nas") //uproszczenie - rozwinięcie jest zakomentowanej linijkę wyzej. Jest też POSTmapping
    public String getAbout(){
        return "about";
    }


}
