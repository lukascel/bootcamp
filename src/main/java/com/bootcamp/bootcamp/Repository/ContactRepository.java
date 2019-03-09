package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long> {
}
