package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseEditionRepository extends JpaRepository <CourseEdition, Long>{
    List<CourseEdition> findAllByOrderById();


@Query("SELECT c FROM CourseEdition c WHERE c.active = 1 and c.id=:id")
CourseEdition getEdition(@Param("id") Long id);

//to co ponizej ale z adnotacją query powyzej

CourseEdition findByIdAndActiveIsTrue(long id);






}
