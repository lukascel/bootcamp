package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.Course;
import com.bootcamp.bootcamp.Models.Trainers;
import com.bootcamp.bootcamp.Repository.CourseEditionRepository;
import com.bootcamp.bootcamp.Repository.CourseModeRepository;
import com.bootcamp.bootcamp.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void saveCourse(Course course){
        courseRepository.save(course);
    }

    public Optional<Course> getCourse(long id){
        Optional<Course> course = courseRepository.findById(id);
        return course;
    }



}
