package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.Trainers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainers, Long> { //JpaRepositoruy jest szerszy niż zastosowany w prezentacji CrudRepository
    List<Trainers> findByFirstName(String firstName);

    List<Trainers> findAllByOrderByLastName();

    //zróbmy to co powyzej za pomocą anotacji QUERY: Uwaga, trzeba używać języka tego do javy. t jest aliasem, Trainers - klasą modelu bo tak sie nazywa ta tabelka w bazie
//    @Query("SELECT t FROM Trainers t WHERE t.lastName=:lastName ORDER BY lastName ASC")
//    List<Trainers> getTrainers(@Param("lastName") String lastName);

    //aby pobierać po wybranym nazwisku:
//    @Query("SELECT t FROM Trainers t WHERE t.lastName=:lastName ORDER BY lastName ASC")
//    List<Trainers> getTrainers(@Param("lastName") String lastName);

}
