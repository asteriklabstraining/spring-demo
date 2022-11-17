package com.example.repository;
import com.example.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    @Query(value = "select * from Teacher where first_name = ?1", nativeQuery = true)
    List<Teacher> findTeacherByFirstName(String firstName);
}