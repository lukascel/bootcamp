package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEditionRepository extends JpaRepository <CourseEdition, Long>{
}
