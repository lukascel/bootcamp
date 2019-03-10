package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.Mode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseModeRepository extends JpaRepository<Mode, Long> {
}
