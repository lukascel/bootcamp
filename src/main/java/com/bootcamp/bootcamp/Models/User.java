package com.bootcamp.bootcamp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Service
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotBlank
    @Pattern(regexp = "^[0-9]{3}[-][0-9]{3}[-][0-9]{3}$", message = "błędny numer") //^ - rozpoczęcie wyrażenia, + - min jeden znak, $ - zakończenie wyrażenia
    private String telefon;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z.|_|-]+[@][a-z]+[.][a-z]+$", message = "błędny e-mail")
    private String email;

    @ManyToOne //wielu userów(klasa w której jestem) do jednej roli
    @JoinColumn(name = "role_id")
    private Role role;

    @NotEmpty
    private String password;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull
    private CourseEdition edition;


}
