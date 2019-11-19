package com.tuto.vle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuto.vle.domain.StudentCode;

public interface StudentCodeRepository extends JpaRepository<StudentCode, Long> {

}
