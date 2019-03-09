package com.bootcamp.bootcamp.Controllers;

import com.bootcamp.bootcamp.Models.Contact;
import com.bootcamp.bootcamp.Services.ContactService;
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
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/kontakt")
    public String contact(Model model){
        model.addAttribute("contact", new Contact()); //ZADANIE - za ten newcontact podaję obiekt z bazy
        return "contact";
    }

    @PostMapping("/wyslij") //post = pobierz.
    public String sendM(@Valid @ModelAttribute Contact contact, BindingResult bindingResult,  Model model){ //modelAtribute przejmuje cały model z formularza.
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage())); //jesli mamy błąd to go pobierz i wyswietl w konsoli. Aby wyswietlic na froncie błędy: str. 127 slajd dodaje przed polem wymaganym. Dwie linijki kodu
        }else {
            model.addAttribute("isSent", true);
            contactService.saveContact(contact);
            System.out.println(contact);
        }
        //model.addAttribute("contact", new Contact()); // NADPISUJE NOWY WIEC CZYSCI POLE TAK NAPRAWDĘ.
        return "contact";
    }

}
