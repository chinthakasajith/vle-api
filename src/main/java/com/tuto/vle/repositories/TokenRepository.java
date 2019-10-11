package com.tuto.vle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}