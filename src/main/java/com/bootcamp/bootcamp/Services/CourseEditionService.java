package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.CourseEdition;
import com.bootcamp.bootcamp.Repository.CourseEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseEditionService {
    @Autowired
    CourseEditionRepository courseEditionRepository;

    public List<CourseEdition> getAllEditions(){
        return courseEditionRepository.findAll();
    }

    public void saveCourseEdition (CourseEdition courseEdition){
        courseEdition.setActive(true);
        courseEditionRepository.save(courseEdition);
    }

    public Optional<CourseEdition> getCourseEdition (long id){
        Optional<CourseEdition> courseEdition = courseEditionRepository.findById(id);
        return courseEdition;
    }

    public CourseEdition getActiveCourseEdition (long id) {
        CourseEdition activeCourseEdition = courseEditionRepository.getEdition(id);
        return activeCourseEdition;
    }

}
