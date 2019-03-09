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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Service
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategy - robi mi tutaj z ID autoincrement.
    private long id;

    @NotEmpty (message = "{com.bootcamp.bootcamp.Models.Trainers.firstName.NotEmpty}")
    private String firstName;

    @NotEmpty (message = "{com.bootcamp.bootcamp.Models.Trainers.lastName.NotEmpty}")
    private String lastName;

    @Positive (message = "{com.bootcamp.bootcamp.Models.Trainers.salary.NotEmpty}")
    private float salary;

    @NotEmpty (message = "{com.bootcamp.bootcamp.Models.Trainers.description.NotEmpty}")
    private String description;

}
