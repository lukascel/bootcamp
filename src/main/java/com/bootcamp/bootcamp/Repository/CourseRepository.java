package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseRepository extends JpaRepository<Course, Long> {
}
