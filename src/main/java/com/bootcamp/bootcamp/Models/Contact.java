package com.bootcamp.bootcamp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Service
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Proszę podać swoje imię!") //automatyczna treść błędu Ale lepiej je wszystkie wsadzić do pliku ValidationMessages (i piszę - nazwa pakiety, klasy, zmiennej i rodzaj validacji.
    private String firstName;

    @NotEmpty(message = "{com.bootcamp.bootcamp.Models.Contact.lastName.NotEmpty}")
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String message;

    private LocalDateTime data;
}
