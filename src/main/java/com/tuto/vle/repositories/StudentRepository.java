package com.tuto.vle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("SELECT s FROM com.tuto.vle.domain.Student s WHERE s.code=?1")
  Student getStudentByStudentID(String code);
}
