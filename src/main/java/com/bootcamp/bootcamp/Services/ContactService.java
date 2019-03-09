package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.Contact;
import com.bootcamp.bootcamp.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveContact(Contact contact){

        contact.setData(LocalDateTime.now());
        contactRepository.save(contact);
    }
}
