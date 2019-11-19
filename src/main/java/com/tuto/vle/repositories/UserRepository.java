package com.tuto.vle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Login;
import com.tuto.vle.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

  Boolean existsByEmail(String email);

  @Query("SELECT new com.tuto.vle.domain.Login(u.userId,u.publicUserId,u.email,u.password,u.firstName,u.lastName,u.isVerified,u.isActive,u.avatar,u.socialType,t.tokenHash) FROM User u join com.tuto.vle.domain.UserTokens ut on u.userId=ut.userId join com.tuto.vle.domain.Token t on t.tokenId=ut.tokenId WHERE u.email=?1 AND u.isActive=1")
  Login authenticateUser(String email);
}
