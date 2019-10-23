package com.tuto.vle.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Token;
import com.tuto.vle.domain.TokenValidity;
import com.tuto.vle.repositories.TokenRepository;

@Service
public class TokenService {

  @Autowired
  TokenRepository tokenRepository;

  public Token generateToken() {

    String tokenHash = null;
    Token token = null;
    long now = System.currentTimeMillis();

    token = new Token();
    tokenHash = UUID.randomUUID().toString();
    token.setTokenHash(tokenHash);
    token.setCreateDt(generatePeriod(0));
    token.setExpireDt(generatePeriod(30));
    token.setType(1);
    token.setStatus(1);

    return tokenRepository.save(token);

  }

  private Timestamp generatePeriod(int nofDays) {
    Timestamp timestamp = new Timestamp(new Date().getTime());
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(timestamp.getTime());
    cal.setTimeInMillis(timestamp.getTime());
    cal.add(Calendar.DAY_OF_MONTH, nofDays);
    timestamp = new Timestamp(cal.getTime().getTime());
    return timestamp;

  }

  public TokenValidity isTokenExpired(String hashToken) {
    return tokenRepository.isTokenExpired(hashToken, generatePeriod(0));
  }
}
