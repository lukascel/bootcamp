package com.bootcamp.bootcamp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Service
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CourseEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne //może byc wiele edycji konkretnego kursu
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course; //odwołuję się do modelu Course bo stamtąd biorę to ID kursu

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Positive
    private long price;

    @Positive
    private int membersLimit;

    @ManyToOne
    @JoinColumn(name = "mode_id")
    @NotNull
    private Mode mode;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    @NotNull
    private Trainers trainer;

    private boolean active;
}
