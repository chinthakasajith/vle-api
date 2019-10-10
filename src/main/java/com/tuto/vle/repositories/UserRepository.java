package com.tuto.vle.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tuto.vle.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Boolean existsByEmail(String email);


}
