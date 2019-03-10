package com.bootcamp.bootcamp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Service

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private  String description;

    @NotBlank
    private String technology;

    @OneToMany //jeden kurs do wielu edycji. Powiązanie jeden do wielu z Edycjami kursów
    private List<CourseEdition> editionsList;

}
