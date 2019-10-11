package com.tuto.vle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.UserTokens;

@Repository
public interface UserTokensRepository extends JpaRepository<UserTokens, Long> {

}
