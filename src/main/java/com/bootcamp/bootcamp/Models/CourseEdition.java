package com.bootcamp.bootcamp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    private Course course; //odwołuję się do modelu Course bo stamtąd biorę to ID kursu

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @Positive
    private long price;

    @Positive
    private int membersLimit;

    @ManyToOne
    @JoinColumn(name = "mode_id")
    private Mode mode;

    private boolean active;
}
