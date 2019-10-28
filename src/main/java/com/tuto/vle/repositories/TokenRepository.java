package com.tuto.vle.repositories;

import java.sql.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Token;
import com.tuto.vle.domain.TokenValidity;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

  @Query("SELECT new com.tuto.vle.domain.TokenValidity(ut.userId,t.tokenId,t.tokenHash) FROM com.tuto.vle.domain.UserTokens ut left join com.tuto.vle.domain.Token t on ut.tokenId=t.tokenId WHERE t.tokenHash=?1 and t.expireDt>?2")
  TokenValidity isTokenExpired(String hashToken, Timestamp expireTimeStamp);

}
