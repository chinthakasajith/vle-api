package com.tuto.vle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

}
